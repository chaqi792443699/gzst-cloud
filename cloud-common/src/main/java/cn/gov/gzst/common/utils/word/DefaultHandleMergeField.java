package cn.gov.gzst.common.utils.word;

import cn.gov.gzst.common.utils.ObjectUtils;
import cn.gov.gzst.common.utils.StringUtils;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.FieldMergingArgs;
import com.aspose.words.IFieldMergingCallback;
import com.aspose.words.ImageFieldMergingArgs;

import java.io.Serializable;
import java.util.*;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.common.utils.word
 * @title:
 * @description: 我们动态的处理MergeField
 * @author: jianliaoliang
 * @date: 2018/5/9 14:19
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class DefaultHandleMergeField implements IFieldMergingCallback {

    private DocumentBuilder mBuilder;
    //HTML字段
    private Map<String,Boolean> htmlFields;

    //图片字段
    private Map<String,ImageParameters> imageFields;

    public DefaultHandleMergeField(){
        this.htmlFields=new HashMap<String,Boolean>();
        this.imageFields=new HashMap<String,ImageParameters>();
    }

    public void markHtmlField(String fieldName){
        this.htmlFields.put(fieldName,Boolean.TRUE);
    }

    public void markImageField(String fieldName,double width,double height){
        ImageParameters imageParameters=new ImageParameters(width,height);
        this.imageFields.put(fieldName,imageParameters);
    }

    public void markImageField(String fieldName){
        ImageParameters imageParameters=new ImageParameters();
        this.imageFields.put(fieldName,imageParameters);
    }

    /**
     * This handler is called for every mail merge field found in the document,
     * for every record found in the data source.
     */
    public void fieldMerging(FieldMergingArgs e) throws Exception {
        if (mBuilder == null) {
            mBuilder = new DocumentBuilder(e.getDocument());
        }
        //处理Html
        if (htmlFields.containsKey(e.getFieldName())) {
            mBuilder.moveToMergeField(e.getFieldName());
            String fieldValue = (String) e.getFieldValue();
            if (!StringUtils.isEmpty(fieldValue)){
                e.setText("");
            }
            mBuilder.insertHtml(fieldValue);
        }
        //处理IMG
        if (imageFields.containsKey(e.getFieldName())) {
            mBuilder.moveToMergeField(e.getFieldName());
            Object fieldValue =  e.getFieldValue();
            ImageParameters imageParameters=imageFields.get(e.getFieldName());
            if (fieldValue instanceof String){
                if (imageParameters.getHeight()==0){
                    mBuilder.insertImage((String)fieldValue);
                }else{
                    mBuilder.insertImage((String)fieldValue,imageParameters.getWidth(),imageParameters.getHeight());
                }
            }else if (fieldValue instanceof byte[]){
                if (imageParameters.getHeight()==0){
                    mBuilder.insertImage((byte[]) fieldValue);
                }else{
                    mBuilder.insertImage((byte[]) fieldValue,imageParameters.getWidth(),imageParameters.getHeight());
                }
            }
        }
    }

    public void imageFieldMerging(ImageFieldMergingArgs args) throws Exception {
        // Do nothing.
    }

    private class ImageParameters implements Serializable{
        private double width;
        private double height;

        public ImageParameters(){

        }

        public ImageParameters(double width,double height){
            this.width=width;
            this.height=height;
        }
        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }

    }

}