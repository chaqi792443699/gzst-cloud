package cn.gov.gzst.common.utils.word;

import cn.gov.gzst.common.filter.xss.JsonUnXssFilter;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.aspose.words.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.common.utils.word
 * @title:
 * @description: Word生成器帮助类
 * @author: jianliaoliang
 * @date: 2018/5/9 14:21
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class WordHelper {
    private String modelUrl;
    private Map<String, Object> data;
    private String outFile;
    private Map<String,Integer> defaultRow;
    private IFieldMergingCallback fieldMergingCallback;
    /**
     * 必须制定输入输出
     */
    public WordHelper(){
        this.fieldMergingCallback = new DefaultHandleMergeField();
        this.data=new HashMap<String,Object>();
        this.defaultRow=new HashMap<String,Integer>();
    }
    /**
     * 必须制定输入输出
     *
     * @param modelUrl
     * @param outFile
     */
    public WordHelper(String modelUrl,String outFile){
        this.fieldMergingCallback = new DefaultHandleMergeField();
        this.data=new HashMap<String,Object>();
        this.defaultRow=new HashMap<String,Integer>();
    }
    /**
     * 必须制定输入输出
     *
     * @param modelUrl
     * @param outFile
     */
    public WordHelper(String modelUrl,String outFile,Object data){
        this.fieldMergingCallback = new DefaultHandleMergeField();
        this.data = new HashMap<String,Object>();
        this.setObject(data);
        this.defaultRow=new HashMap<String,Integer>();
    }



    public String getModelUrl() {
        return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
        this.modelUrl = modelUrl;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(String key,Object object) {
        if (this.data==null) {
            this.data = new HashMap<String, Object>();
        }
        this.data.put(key,object);
    }
    public void setData(Map<String, Object> data) {
        if (this.data==null) {
            this.data = new HashMap<String, Object>();
        }
        this.setObject(data);
    }

    public String getOutFile() {
        return outFile;
    }

    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public Map<String, Integer> getDefaultRow() {
        return defaultRow;
    }

    public void setDefaultRow(Map<String, Integer> defaultRow) {
        this.defaultRow = defaultRow;
    }

    public IFieldMergingCallback getFieldMergingCallback() {
        return fieldMergingCallback;
    }

    public void setFieldMergingCallback(IFieldMergingCallback fieldMergingCallback) {
        this.fieldMergingCallback = fieldMergingCallback;
    }

    public void setList(String key,List list){
        this.setList(key,list,"");
    }

    public void setList(String key,List list,String fieldName){
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter(fieldName);
        SerializeFilter propertyPreFilter = propertyPreFilterable.constructFilter(list.get(0).getClass().getClass());
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        SerializeFilter[] filters={propertyPreFilter,jsonUnFilter};
        String objectStr= JSON.toJSONString(list,filters);
        List<Map> listMap= JSON.parseObject(objectStr,List.class);
        this.data.put(key,listMap);
    }

    public void setList(String key,List list,String fieldName,Integer defaultRow){
        this.defaultRow.put(key,defaultRow);
        this.setList(key,list,fieldName);
    }

    public void setList(String key,List list,Integer defaultRow){
        this.setList(key,list,null,defaultRow);
    }


    public void setObject(String key,Object object){
        setObject(key,object,"");
    }

    public void setObject(String key,Object object,String fieldName){
        if (object instanceof List){
            this.setList(key, (List) object,fieldName);
        }else {
            PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter(fieldName);
            SerializeFilter propertyPreFilter = propertyPreFilterable.constructFilter(object.getClass());
            JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
            SerializeFilter[] filters = {propertyPreFilter, jsonUnFilter};
            String objectStr = JSON.toJSONString(object, filters);
            Map dataMap = JSON.parseObject(objectStr, Map.class);
            this.data.put(key, dataMap);
        }
    }

    public void setObject(Object object){
        this.setObject(object,"");
    }

    public void setObject(Object object,String fieldName){
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter(fieldName);
        SerializeFilter propertyPreFilter = propertyPreFilterable.constructFilter(object.getClass());
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        SerializeFilter[] filters={propertyPreFilter,jsonUnFilter};
        String objectStr=JSON.toJSONString(object,filters);
        Map dataMap= JSON.parseObject(objectStr,Map.class);
        this.data.putAll(dataMap);
    }

}
