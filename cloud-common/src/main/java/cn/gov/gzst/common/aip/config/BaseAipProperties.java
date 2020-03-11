package cn.gov.gzst.common.aip.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * All rights Reserved, Designed By www.dataact.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.boot.common.baidu.aip
 * @title:
 * @description: 百度aip
 * @author: jianliaoliang
 * @date: 2018/4/21 17:58
 * @copyright: 2017 www.dataact.cn Inc. All rights reserved.
 */
@ConfigurationProperties("baidu.aip")
public class BaseAipProperties{
    private String appId;
    private String apiKey;
    private String secretKey;

    public BaseAipProperties(){

    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
