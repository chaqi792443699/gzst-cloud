package cn.gov.gzst.sms.utils;

import cn.gov.gzst.common.query.wrapper.EntityWrapper;
import cn.gov.gzst.common.utils.CacheUtils;
import cn.gov.gzst.common.utils.SpringContextHolder;
import cn.gov.gzst.sms.entity.SmsConfig;
import cn.gov.gzst.sms.service.ISmsConfigService;

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

    public static Map<String, SmsConfig> getConfigMap() {
        //数据字典
        if (CacheUtils.get(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY)==null || CacheUtils.get(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY) == null){
            initConfig();
        }
       return  (Map<String, SmsConfig>) CacheUtils.get(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY);
    }

    public static SmsConfig getConfig(String id) {
         return getConfigMap().get(id);
    }
    /**
     * 数据字典初始化
     * @return
     */
    public static Map<String, SmsConfig> initConfig() {
        Map<String,SmsConfig> configMap = new HashMap<String, SmsConfig>();
        for (SmsConfig config : SpringContextHolder.getBean(ISmsConfigService.class).selectList(new EntityWrapper<SmsConfig>())) {
            configMap.put(config.getId(),config);
        }
        putConfig(configMap);
        return configMap;
    }

    /**
     * 放入缓存
     * @param configMap
     */
    public static void putConfig(Map<String,SmsConfig> configMap) {
        CacheUtils.put(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY, configMap);
    }

    /*
     * 清除换成
     */
    public static void clear() {
        CacheUtils.remove(CONFIG_CACHE_NAME,CONFIG_CACHE_KEY);
    }
}
