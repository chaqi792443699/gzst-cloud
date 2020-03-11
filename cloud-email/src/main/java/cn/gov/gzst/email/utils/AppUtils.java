package cn.gov.gzst.email.utils;

import cn.gov.gzst.common.utils.CacheUtils;
import cn.gov.gzst.common.utils.SpringContextHolder;
import cn.gov.gzst.admin.bean.App;
import cn.gov.gzst.admin.feign.AppFeign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用程序缓存
 */
public class AppUtils {

    public static String APP_CACHE_KEY = "APP_CACHE_KEY";
    protected final static String APP_CACHE_NAME = "appCache";

    public static Map<String, App> getAppMap() {
        //数据字典
        if (CacheUtils.get(APP_CACHE_NAME, APP_CACHE_KEY) == null || CacheUtils.get(APP_CACHE_NAME, APP_CACHE_KEY) == null) {
            initApp();
        }
        return (Map<String, App>) CacheUtils.get(APP_CACHE_NAME, APP_CACHE_KEY);
    }

    public static App getApp(String id) {
        //数据字典
        if (getAppMap().get(id) == null) {
            initApp();
        }
        return getAppMap().get(id);
    }

    /**
     * 数据字典初始化
     *
     * @return
     */
    public static Map<String, App> initApp() {
        Map<String, App> appMap = new HashMap<String, App>();
        List<App> appList = SpringContextHolder.getBean(AppFeign.class).listAvalable();
        if (appList != null) {
            for (App app : appList) {
                appMap.put(app.getId(), app);
            }
        }
        putApp(appMap);
        return appMap;
    }

    /**
     * 放入缓存
     *
     * @param appMap
     */
    public static void putApp(Map<String, App> appMap) {
        CacheUtils.put(APP_CACHE_NAME, APP_CACHE_KEY, appMap);
    }

    /*
     * 清除换成
     */
    public static void clear() {
        CacheUtils.remove(APP_CACHE_NAME, APP_CACHE_KEY);
    }
}
