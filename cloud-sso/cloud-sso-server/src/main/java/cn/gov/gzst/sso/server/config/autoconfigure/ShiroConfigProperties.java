package cn.gov.gzst.sso.server.config.autoconfigure;

import cn.gov.gzst.common.utils.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * shiro配置文件
 */
@ConfigurationProperties(prefix = "cloud.shiro")
public class ShiroConfigProperties {
    //系统管理员密码重试次数
    private Integer  userPasswordShowCaptchaRetryCount=3;
    //凭证匹配器-算法
    private  String credentialsHashAlgorithmName="md5";
    //生成Hash值的迭代次数
    private Integer credentialsHashIterations=2;

    //表示是否存储散列后的密码为16进制，需要和生成密码时的一样
    private Boolean credentialsStoredCredentialsHexEncoded=Boolean.TRUE;
    //全局session超时时间 1000*30*60milliseconds = 30 分钟（1800000）
    private Integer sessionGlobalSessionTimeout=1800000;
    //session验证时间间隔(即验证会话是否还有效) 1000*60*60milliseconds = 1小时（3600000）
    private Integer sessionValidationInterval=3600000;
    //session 缓存的名字
    private String activeSessionCacheName="shiro-activeSessionCache";
    //CookieName
    private String sessionIdCookieName="shiro-sessionId";
    //CookieName
    private String sessionIdCookieDomain="";
    private String sessionIdCookiePath="/";
    private Boolean sessionIdCookieHttpOnly=Boolean.TRUE;
    //默认uid cookie 浏览器关闭后销毁
    private Integer sessionIdCookieMaxAge=-1;
    //rememeber me cookie 名字
    private String  rememeberMeCookieName="shiro-rememeberMeCache";
    private String  rememeberMeCookieDomain="";
    private String  rememeberMeCookiePath="/";
    private Boolean rememeberMeCookieHttpOnly=Boolean.TRUE;
   //默认 rememberMe cookie 60 * 60 * 24 * 30 （30天）
    private Integer rememeberMeCookieMaxAge=2592000;
    //cipherKey
    private String rememeberMeCookieBase64CipherKey="KU471rVNQ6k7PQL4SqxgJg==";
    //登录地址
    private String loginUrl="/login";
    //跳转URL
    private String redirectUrl="/redirect";

    //政务服务中心应用ID
    private String serviceCenterAppId;

    //政务服务中心应用密钥
    private String serviceCenterAppSecret;

    //项目管理系统登陆
    private String pmsLoginUrl="";
    //退出地址
    private String logoutSuccessUrl="";
    //用户删除后
    private String  userNotfoundUrl="";
    //用户锁定地址
    private String  userLockedUrl="";
    //未知错误地址
    private String  userUnknownErrorUrl="";
    //未知错误地址
    private String userForceLogoutUrl="";
    //没有授权地址
    private String unauthorizedUrl="/unauthorized";
   //默认的登录成功页
    private String  defaultSuccessUrl="/";
   //验证码是否开启
   private Boolean jcaptchaEnable=Boolean.TRUE;
     //验证码错误时重定向的地址
    private String jcaptchaErrorUrl="/login?jcaptchaError=1";
    //
    private Integer codeExpiresIn = 10*60 ;
    //access_token过期时间，为两小时
    private Integer accesTokenExpiresIn= 2*60*60;
    //refresh_token过期时间，为30天
    private Integer refreshTokenExpiresIn= 30*24*60*60;

    public Integer getUserPasswordShowCaptchaRetryCount() {
        return userPasswordShowCaptchaRetryCount;
    }

    public void setUserPasswordShowCaptchaRetryCount(Integer userPasswordShowCaptchaRetryCount) {
        this.userPasswordShowCaptchaRetryCount = userPasswordShowCaptchaRetryCount;
    }

    public String getCredentialsHashAlgorithmName() {
        return credentialsHashAlgorithmName;
    }

    public void setCredentialsHashAlgorithmName(String credentialsHashAlgorithmName) {
        this.credentialsHashAlgorithmName = credentialsHashAlgorithmName;
    }

    public Integer getCredentialsHashIterations() {
        return credentialsHashIterations;
    }

    public void setCredentialsHashIterations(Integer credentialsHashIterations) {
        this.credentialsHashIterations = credentialsHashIterations;
    }

    public Boolean getCredentialsStoredCredentialsHexEncoded() {
        return credentialsStoredCredentialsHexEncoded;
    }

    public void setCredentialsStoredCredentialsHexEncoded(Boolean credentialsStoredCredentialsHexEncoded) {
        this.credentialsStoredCredentialsHexEncoded = credentialsStoredCredentialsHexEncoded;
    }

    public Integer getSessionGlobalSessionTimeout() {
        return sessionGlobalSessionTimeout;
    }

    public void setSessionGlobalSessionTimeout(Integer sessionGlobalSessionTimeout) {
        this.sessionGlobalSessionTimeout = sessionGlobalSessionTimeout;
    }

    public Integer getSessionValidationInterval() {
        return sessionValidationInterval;
    }

    public void setSessionValidationInterval(Integer sessionValidationInterval) {
        this.sessionValidationInterval = sessionValidationInterval;
    }

    public String getActiveSessionCacheName() {
        return activeSessionCacheName;
    }

    public void setActiveSessionCacheName(String activeSessionCacheName) {
        this.activeSessionCacheName = activeSessionCacheName;
    }

    public String getSessionIdCookieName() {
        return sessionIdCookieName;
    }

    public void setSessionIdCookieName(String sessionIdCookieName) {
        this.sessionIdCookieName = sessionIdCookieName;
    }

    public String getSessionIdCookieDomain() {
        return sessionIdCookieDomain;
    }

    public void setSessionIdCookieDomain(String sessionIdCookieDomain) {
        this.sessionIdCookieDomain = sessionIdCookieDomain;
    }

    public String getSessionIdCookiePath() {
        return sessionIdCookiePath;
    }

    public void setSessionIdCookiePath(String sessionIdCookiePath) {
        this.sessionIdCookiePath = sessionIdCookiePath;
    }

    public Boolean getSessionIdCookieHttpOnly() {
        return sessionIdCookieHttpOnly;
    }

    public void setSessionIdCookieHttpOnly(Boolean sessionIdCookieHttpOnly) {
        this.sessionIdCookieHttpOnly = sessionIdCookieHttpOnly;
    }

    public Integer getSessionIdCookieMaxAge() {
        return sessionIdCookieMaxAge;
    }

    public void setSessionIdCookieMaxAge(Integer sessionIdCookieMaxAge) {
        this.sessionIdCookieMaxAge = sessionIdCookieMaxAge;
    }

    public String getRememeberMeCookieName() {
        return rememeberMeCookieName;
    }

    public void setRememeberMeCookieName(String rememeberMeCookieName) {
        this.rememeberMeCookieName = rememeberMeCookieName;
    }

    public String getRememeberMeCookieDomain() {
        return rememeberMeCookieDomain;
    }

    public void setRememeberMeCookieDomain(String rememeberMeCookieDomain) {
        this.rememeberMeCookieDomain = rememeberMeCookieDomain;
    }

    public String getRememeberMeCookiePath() {
        return rememeberMeCookiePath;
    }

    public void setRememeberMeCookiePath(String rememeberMeCookiePath) {
        this.rememeberMeCookiePath = rememeberMeCookiePath;
    }

    public Boolean getRememeberMeCookieHttpOnly() {
        return rememeberMeCookieHttpOnly;
    }

    public void setRememeberMeCookieHttpOnly(Boolean rememeberMeCookieHttpOnly) {
        this.rememeberMeCookieHttpOnly = rememeberMeCookieHttpOnly;
    }

    public Integer getRememeberMeCookieMaxAge() {
        return rememeberMeCookieMaxAge;
    }

    public void setRememeberMeCookieMaxAge(Integer rememeberMeCookieMaxAge) {
        this.rememeberMeCookieMaxAge = rememeberMeCookieMaxAge;
    }

    public String getRememeberMeCookieBase64CipherKey() {
        return rememeberMeCookieBase64CipherKey;
    }

    public void setRememeberMeCookieBase64CipherKey(String rememeberMeCookieBase64CipherKey) {
        this.rememeberMeCookieBase64CipherKey = rememeberMeCookieBase64CipherKey;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutSuccessUrl() {
        if (StringUtils.isEmpty(logoutSuccessUrl)){
            return getLoginUrl()+"?error_type=logout";
        }
        return logoutSuccessUrl;
    }

    public void setLogoutSuccessUrl(String logoutSuccessUrl) {
        this.logoutSuccessUrl = logoutSuccessUrl;
    }

    public String getUserNotfoundUrl() {
        if (StringUtils.isEmpty(userNotfoundUrl)){
            return getLoginUrl()+"?error_type=userNotfound";
        }
        return userNotfoundUrl;
    }

    public void setUserNotfoundUrl(String userNotfoundUrl) {
        this.userNotfoundUrl = userNotfoundUrl;
    }

    public String getUserLockedUrl() {
        if (StringUtils.isEmpty(userNotfoundUrl)){
            return getLoginUrl()+"?error_type=userBlocked";
        }
        return userLockedUrl;
    }

    public void setUserLockedUrl(String userLockedUrl) {
        this.userLockedUrl = userLockedUrl;
    }

    public String getUserUnknownErrorUrl() {
        if (StringUtils.isEmpty(userUnknownErrorUrl)){
            return getLoginUrl()+"?error_type=userUnknown";
        }
        return userUnknownErrorUrl;
    }

    public void setUserUnknownErrorUrl(String userUnknownErrorUrl) {
        this.userUnknownErrorUrl = userUnknownErrorUrl;
    }

    public String getUserForceLogoutUrl() {
        if (StringUtils.isEmpty(userForceLogoutUrl)){
            return getLoginUrl()+"?error_type=userForce";
        }
        return userForceLogoutUrl;
    }

    public void setUserForceLogoutUrl(String userForceLogoutUrl) {
        this.userForceLogoutUrl = userForceLogoutUrl;
    }

    public String getUnauthorizedUrl() {
        return unauthorizedUrl;
    }

    public void setUnauthorizedUrl(String unauthorizedUrl) {
        this.unauthorizedUrl = unauthorizedUrl;
    }

    public String getDefaultSuccessUrl() {
        return defaultSuccessUrl;
    }

    public void setDefaultSuccessUrl(String defaultSuccessUrl) {
        this.defaultSuccessUrl = defaultSuccessUrl;
    }

    public Boolean getJcaptchaEnable() {
        return jcaptchaEnable;
    }

    public void setJcaptchaEnable(Boolean jcaptchaEnable) {
        this.jcaptchaEnable = jcaptchaEnable;
    }

    public String getJcaptchaErrorUrl() {
        return jcaptchaErrorUrl;
    }

    public void setJcaptchaErrorUrl(String jcaptchaErrorUrl) {
        this.jcaptchaErrorUrl = jcaptchaErrorUrl;
    }

    public Integer getCodeExpiresIn() {
        return codeExpiresIn;
    }

    public void setCodeExpiresIn(Integer codeExpiresIn) {
        this.codeExpiresIn = codeExpiresIn;
    }

    public Integer getAccesTokenExpiresIn() {
        return accesTokenExpiresIn;
    }

    public void setAccesTokenExpiresIn(Integer accesTokenExpiresIn) {
        this.accesTokenExpiresIn = accesTokenExpiresIn;
    }

    public Integer getRefreshTokenExpiresIn() {
        return refreshTokenExpiresIn;
    }

    public void setRefreshTokenExpiresIn(Integer refreshTokenExpiresIn) {
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public String getServiceCenterAppId() {
        return serviceCenterAppId;
    }

    public void setServiceCenterAppId(String serviceCenterAppId) {
        this.serviceCenterAppId = serviceCenterAppId;
    }

    public String getServiceCenterAppSecret() {
        return serviceCenterAppSecret;
    }

    public void setServiceCenterAppSecret(String serviceCenterAppSecret) {
        this.serviceCenterAppSecret = serviceCenterAppSecret;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getPmsLoginUrl() {
        return pmsLoginUrl;
    }

    public void setPmsLoginUrl(String pmsLoginUrl) {
        this.pmsLoginUrl = pmsLoginUrl;
    }
}
