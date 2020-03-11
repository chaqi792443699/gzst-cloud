package cn.gov.gzst.sso.common.bean;



import cn.gov.gzst.common.utils.BeanUtils;
import cn.gov.gzst.common.utils.Reflections;
import cn.gov.gzst.sso.common.utils.MessageUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.pms.api.common.constant
 * @title:
 * @description: 接口返回
 * @author: jianliaoliang
 * @date: 2018/1/9 9:09
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class ResponseResult extends HashMap<String,Object>{

    public ResponseResult putList(String key,String fieldName,List list){
        List<Map<String,Object>> dataList=new ArrayList<Map<String,Object>>();
        for (Object object:list) {
            Map<String,Object> itemMap=new HashMap<String,Object>();
            String[] fieldNames=fieldName.split(",");
            for (String field: fieldNames) {
                String[] fieldItems=field.split("\\|");
                if (fieldItems.length==2) {
                    put(fieldItems[1], Reflections.getFieldValue(object, fieldItems[0]));
                }else{
                    put(field, Reflections.getFieldValue(object, field));
                }
            }
            dataList.add(itemMap);
        }
        put(key,dataList);
        return this;
    }

   public ResponseResult putObject(Object object,String fieldName){
        String[] fieldNames=fieldName.split(",");
       for (String field: fieldNames) {
           String[] fieldItems=field.split("\\|");
           if (fieldItems.length==2) {
               put(fieldItems[1], Reflections.getFieldValue(object, fieldItems[0]));
           }else{
               put(field, Reflections.getFieldValue(object, field));
           }
       }
       return this;
   }

    public ResponseResult putObject(Object object) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map dataMap= BeanUtils.describe(object);
        putAll(dataMap);
        return this;
    }

    public ResponseResult ok(){
        fail(ResponseError.OK);
        return this;
    }

    public ResponseResult ok(String msg){
        fail(ResponseError.OK,msg);
        return this;
    }


    public ResponseResult fail(int code){
      fail(code, MessageUtils.getMessageByErrCode(code));
      return this;
   }

    public ResponseResult fail(int code,String msg) {
        put("errcode", code);
        put("errmsg", msg);
        return this;
    }

}
