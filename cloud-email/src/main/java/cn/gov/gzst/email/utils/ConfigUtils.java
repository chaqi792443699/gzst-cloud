package cn.gov.gzst.email.utils;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.CacheUtils;
import cn.gov.gzst.common.utils.SpringContextHolder;
import cn.gov.gzst.email.entity.Config;
import cn.gov.gzst.email.service.IConfigService;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.utils
 * @title:
 * @description:  配置缓存
 * @author: jianliaoliang
 * @date: 2018/3/22 16:11
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
public class ConfigUtils {

    public static String CONFIG_CACHE_KEY = "CONFIG_CACHE_KEY";
    protected final static String CONFIG_CACHE_NAME = "configCache";

    public static Map<String, Config> getConfigMap() {
        //数据字典
        if (CacheUtils.get(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY)==null || CacheUtils.get(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY) == null){
            initConfig();
        }
       return  (Map<String, Config>) CacheUtils.get(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY);
    }

    public static Config getConfig(String id) {
         return getConfigMap().get(id);
    }
    /**
     * 数据字典初始化
     * @return
     */
    public static Map<String, Config> initConfig() {
        Map<String,Config> configMap = new HashMap<String, Config>();
        for (Config config : SpringContextHolder.getBean(IConfigService.class).selectList(new EntityWrapper<Config>())) {
            configMap.put(config.getId(),config);
        }
        putConfig(configMap);
        return configMap;
    }

    /**
     * 放入缓存
     * @param configMap
     */
    public static void putConfig(Map<String,Config> configMap) {
        CacheUtils.put(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY, configMap);
    }

    /*
     * 清除换成
     */
    public static void clear() {
        CacheUtils.remove(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY);
    }
}
