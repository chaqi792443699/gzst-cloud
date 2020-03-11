package cn.gov.gzst.admin.utils;

import cn.gov.gzst.activiti.bean.Act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.admin.utils
 * @title:
 * @description: 获得所有实例ID
 * @author: jianliaoliang
 * @date: 2018/5/5 17:39
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
public class ActUtils {
   public static  List<String>  getProcInsIdList(List<Act> actList){
        List<String> procInsIdList=new ArrayList<String>();
        for (Act act:actList) {
            procInsIdList.add(act.getProcInsId());
        }
        return procInsIdList;
    }

    public static  Map<String,Act> getProcInsIdMap(List<Act> actList){
        Map<String,Act> procInsIdMap=new HashMap<String,Act>();
        for (Act act:actList) {
            procInsIdMap.put(act.getProcInsId(),act);
        }
        return procInsIdMap;
    }

 }
