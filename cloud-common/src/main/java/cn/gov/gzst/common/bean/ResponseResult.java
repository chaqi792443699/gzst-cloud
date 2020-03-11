package cn.gov.gzst.common.bean;

import cn.gov.gzst.common.filter.xss.JsonUnXssFilter;
import cn.gov.gzst.common.query.data.PropertyPreFilterable;
import cn.gov.gzst.common.query.data.QueryPropertyPreFilter;
import cn.gov.gzst.common.utils.MessageUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *接口返回数据
 */
public class ResponseResult extends HashMap<String,Object>{

    public ResponseResult putList(String key,List<?> list,String fieldName){
        PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter(fieldName);
        SerializeFilter propertyPreFilter = propertyPreFilterable.constructFilter(list.get(0).getClass());
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        SerializeFilter[] filters={propertyPreFilter,jsonUnFilter};
        String objectStr=JSON.toJSONString(list,filters);
        List<Map> dataMap= JSON.parseObject(objectStr,List.class);
        put(key,dataMap);
        return this;
    }

   public ResponseResult putObject(Object object,String fieldName){
       PropertyPreFilterable propertyPreFilterable=new QueryPropertyPreFilter(fieldName);
       SerializeFilter propertyPreFilter = propertyPreFilterable.constructFilter(object.getClass());
       JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
       SerializeFilter[] filters={propertyPreFilter,jsonUnFilter};
       String objectStr=JSON.toJSONString(object,filters);
       Map dataMap= JSON.parseObject(objectStr,Map.class);
       putAll(dataMap);
       return this;
   }

    public ResponseResult putObject(Object object){
        JsonUnXssFilter jsonUnFilter = new JsonUnXssFilter();
        String objectStr=JSON.toJSONString(object,jsonUnFilter);
        Map dataMap= JSON.parseObject(objectStr,Map.class);
        dataMap.remove("class");
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
      fail(code, "操作失败");
      return this;
   }

    public ResponseResult fail(int code,String msg) {
        put("errcode", code);
        put("errmsg", msg);
        return this;
    }

}
