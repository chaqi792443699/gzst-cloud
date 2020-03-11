package cn.gov.gzst.sso.client.config.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.jeeweb.config.autoconfigure
 * @title:
 * @description: shiro属性配置文件
 * @author: jianliaoliang
 * @date: 2018/3/6 10:33
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@ConfigurationProperties(prefix = "cloud.shiro.oauth2")
public class ShiroConfigProperties {
    private String clientId=""; ////客户端的客户端ID
    private String clientSecret=""; ////客户端的客户端密钥
    //获取授权
    private String authorizeUrl="";
    //获取授权
    private String accessTokenUrl="";
    //获得用户URL
    private String userInfoUrl="";
    private Boolean syncLogin=Boolean.FALSE;
    private String  registerLoginUrl="";
    private String  forceRefreshUrl="";
    private String  logoutUrl="";
    private String  redirectSuccessUrl="";
    private String redirectFailUrl="";

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getAuthorizeUrl() {
        return authorizeUrl;
    }

    public void setAuthorizeUrl(String authorizeUrl) {
        this.authorizeUrl = authorizeUrl;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public void setAccessTokenUrl(String accessTokenUrl) {
        this.accessTokenUrl = accessTokenUrl;
    }

    public String getRedirectSuccessUrl() {
        return redirectSuccessUrl;
    }

    public void setRedirectSuccessUrl(String redirectSuccessUrl) {
        this.redirectSuccessUrl = redirectSuccessUrl;
    }

    public String getUserInfoUrl() {
        return userInfoUrl;
    }

    public void setUserInfoUrl(String userInfoUrl) {
        this.userInfoUrl = userInfoUrl;
    }

    public Boolean getSyncLogin() {
        return syncLogin;
    }

    public void setSyncLogin(Boolean syncLogin) {
        this.syncLogin = syncLogin;
    }

    public String getRegisterLoginUrl() {
        return registerLoginUrl;
    }

    public void setRegisterLoginUrl(String registerLoginUrl) {
        this.registerLoginUrl = registerLoginUrl;
    }

    public String getForceRefreshUrl() {
        return forceRefreshUrl;
    }

    public void setForceRefreshUrl(String forceRefreshUrl) {
        this.forceRefreshUrl = forceRefreshUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getRedirectFailUrl() {
        return redirectFailUrl;
    }

    public void setRedirectFailUrl(String redirectFailUrl) {
        this.redirectFailUrl = redirectFailUrl;
    }
}
