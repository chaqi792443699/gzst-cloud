package cn.gov.gzst.activiti.utils;

import cn.gov.gzst.admin.bean.User;
import cn.gov.gzst.admin.feign.UserFeign;
import cn.gov.gzst.common.utils.CacheUtils;
import cn.gov.gzst.common.utils.SpringContextHolder;
import cn.gov.gzst.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.utils
 * @title:
 * @description:  用户缓存
 * @author: jianliaoliang
 * @date: 2018/3/22 16:11
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class UserCacheUtils {

    public static String USER_CACHE_KEY = "USER_CACHE_KEY";
    protected final static String USER_CACHE_NAME = "userCache";
    private final static List<String> userList=new ArrayList<String>();


    public static Map<String, User> getUserMap() {
        if ((Map<String, User>) CacheUtils.get(USER_CACHE_NAME,USER_CACHE_KEY)==null){
            Map<String,User> userMap = new HashMap<>();
            putUser(userMap);
        }
       return  (Map<String, User>) CacheUtils.get(USER_CACHE_NAME,USER_CACHE_KEY);
    }

    public static void addUserId(String userId){
        if (StringUtils.isEmpty(userId)){
            return;
        }
        if (!UserCacheUtils.checkUser(userId)){
            userList.add(userId);
        }
    }

    public static Boolean checkUser(String id) {
        if (StringUtils.isEmpty(id)){
            return Boolean.FALSE;
        }
        Map<String, User> userMap=getUserMap();
        if (getUserMap().get(id)==null){
           return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static String getUserName(String id) {
        User user=getUserMap().get(id);
        if (user!=null){
            if (StringUtils.isEmpty(user.getRealName())){
                return user.getUsername();
            }
            return user.getRealName();
        }
        return "";
    }


    public static User getUser(String id) {
         return getUserMap().get(id);
    }
    public static void initUser() {
        if (userList.size()>0) {
            UserCacheUtils.initUser(userList.toArray(new String[userList.size()]));
            userList.clear();
        }
    }

    /**
     *  初始化用户信息
     * @return
     */
    public static Map<String, User> initUser(String[] ids) {
        Map<String,User> userMap = getUserMap();
        List<User> userList= SpringContextHolder.getBean(UserFeign.class).findListByIds(ids);
        if (userList!=null) {
            for (User user : userList) {
                userMap.put(user.getId(), user);
            }
        }
        putUser(userMap);
        return userMap;
    }

    /**
     * 放入缓存
     * @param userMap
     */
    public static void putUser(Map<String,User> userMap) {
        CacheUtils.put(USER_CACHE_NAME,USER_CACHE_KEY, userMap);
    }

    /*
     * 清除换成
     */
    public static void clear() {
        CacheUtils.remove(USER_CACHE_NAME,USER_CACHE_KEY);
    }
}
