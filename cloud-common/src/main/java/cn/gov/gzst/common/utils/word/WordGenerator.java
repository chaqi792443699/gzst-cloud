package cn.gov.gzst.common.utils.word;

import cn.gov.gzst.common.utils.BeanUtils;
import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.PdfUtil;
import com.aspose.words.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.common.utils.word
 * @title:
 * @description: Cache工具类
 * @author: jianliaoliang
 * @date: 2018/5/9 14:21
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class WordGenerator {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public WordHelper wordHelper;
    public WordGenerator(){
        this.wordHelper=new WordHelper();
    }
    public WordGenerator(WordHelper wordHelper){
        this.wordHelper=wordHelper;
    }

    public WordGenerator(String modelUrl,String outFile){
        this.wordHelper=new WordHelper(modelUrl,outFile);
    }

    public WordGenerator(String modelUrl,String outFile,Object data){
        this.wordHelper=new WordHelper(modelUrl,outFile);
    }

    public WordHelper getWordHelper() {
        return wordHelper;
    }

    public void setWordHelper(WordHelper wordHelper) {
        this.wordHelper = wordHelper;
    }

    public void generate() throws Exception {
        getLicense();
        File file = new File(wordHelper.getOutFile());
        file.getParentFile().mkdirs();
        Document doc = this.generate(wordHelper.getModelUrl(),wordHelper.getData(),wordHelper.getDefaultRow(),wordHelper.getFieldMergingCallback());
        doc.save(file.getAbsolutePath(), SaveFormat.DOC);
    }

    /**
     * docx模板的时候覆盖此方法
     * 返回Document对象
     * @return
     * @throws Exception
     */
    public Document generate(String modelUrl, Map<String, Object> data,Map<String,Integer> defaultRow,IFieldMergingCallback fieldMergingCallback) throws Exception {
        Document doc =  new Document(modelUrl);
        //设置merge处理类
        doc.getMailMerge().setFieldMergingCallback(fieldMergingCallback);
        doc.getMailMerge().setCleanupOptions(MailMergeCleanupOptions.REMOVE_UNUSED_FIELDS);

        //值域初始化
        List<String> fieldList = new ArrayList<String>();
        List<Object> valueList = new ArrayList<Object>();
        DataSet dataSet = new DataSet();
        for (String key : data.keySet()) { //这里不去一直处理子节点
            Object value=data.get(key);
            if (!(value instanceof List)&&!(value instanceof Map)){
                //添加基础的
                fieldList.add(key);
                if(ObjectUtils.isNullOrEmpty(value)){
                    value="";
                }
                valueList.add(value);
            }else if(value instanceof List){ //如果list之类的类型,在添加之前转换为map
                DataTable dataTable = new DataTable(key);
                List<Map<String,Object>> dataList = (List<Map<String,Object>>)value;
                if (dataList.size() > 0) {
                    Map<String, Object> childFirst = dataList.get(0);
                    for (String fieldName : childFirst.keySet()) {
                        dataTable.getColumns().add(fieldName);
                    }
                    //向表格中填充数据
                    for(Map<String, Object> child : dataList){
                        DataRow row = dataTable.newRow();
                        int fieldIndex = 0;
                        for (String fieldName : child.keySet()) {
                            row.set(fieldIndex,child.get(fieldName));
                            fieldIndex ++;
                        }
                        dataTable.getRows().add(row);
                    }
                }
                //对于无数据的情况，增加一行空记录
                int cnt = dataTable.getRows().getCount();
                int rowCnt = 0;
                //在注入的配置中取出需要额外补齐的行数
                if (defaultRow.containsKey(key)){
                    rowCnt = defaultRow.get(key);
                }
                if(cnt < rowCnt){
                    for (int i = 0; i < rowCnt - cnt; i ++) {
                        DataRow row = dataTable.newRow();
                        dataTable.getRows().add( row );
                    }
                }
                dataSet.getTables().add(dataTable);
            }else if(value instanceof Map){//如果list之类的类型
                Map<String,Object> subMapData = (Map<String,Object>)value;
                for (String subKey : subMapData.keySet()) {
                    //添加基础的
                    fieldList.add(key+"."+subKey);
                    if (ObjectUtils.isNullOrEmpty(value)) {
                        value = "";
                    }
                    valueList.add(subMapData.get(subKey));
                }
            }
        }

        String[] Flds = new String[fieldList.size()];//域
        Object[] Vals = new Object[fieldList.size()]; //域值
        fieldList.toArray(Flds);
        valueList.toArray(Vals);
        doc.getMailMerge().execute(Flds, Vals); //调用接口
        doc.getMailMerge().executeWithRegions(dataSet);
        return doc;
    }

    /**
     * 获取license
     *
     * @return
     */
    private boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = PdfUtil.class.getClassLoader().getResourceAsStream("license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ex="+e.toString());
        }
        return result;
    }

}
