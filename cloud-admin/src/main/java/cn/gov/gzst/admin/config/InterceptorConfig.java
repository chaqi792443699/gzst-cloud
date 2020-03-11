package cn.gov.gzst.admin.config;

import cn.gov.gzst.admin.interceptors.LogInterceptor;
import cn.gov.gzst.admin.service.impl.UserServiceImpl;
import cn.gov.gzst.common.common.service.ISSOPermissionService;
import cn.gov.gzst.common.interceptor.EncodingInterceptor;
import cn.gov.gzst.common.security.auth.CloudSSOAuthorization;
import com.baomidou.kisso.web.interceptor.SSOPermissionInterceptor;
import com.baomidou.kisso.web.interceptor.SSOSpringInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @description: 拦截器
 * @author: jianliaoliang
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

    /**
     * 编码拦截器
     *
     * @return
     */
    @Bean
    public HandlerInterceptor encodingInterceptor() {
        EncodingInterceptor encodingInterceptor = new EncodingInterceptor();
        return encodingInterceptor;
    }

    @Bean
    public ISSOPermissionService ssoPermissionService() {
        ISSOPermissionService issoPermissionService = new UserServiceImpl();
        return issoPermissionService;
    }

    @Bean
    public CloudSSOAuthorization authorization() {
        CloudSSOAuthorization authorization = new CloudSSOAuthorization();
        authorization.setPermissionService(ssoPermissionService());
        return authorization;
    }

    @Bean
    public HandlerInterceptor logInterceptor() {
        HandlerInterceptor logInterceptor = new LogInterceptor();
        ((LogInterceptor) logInterceptor).setOpenAccessLog(true);
        return logInterceptor;
    }

    /**
     * 增加kisso的拦截处理
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // kisso 拦截器配置
        logger.info("kisso init");
        SSOSpringInterceptor ssoSpringInterceptor = new SSOSpringInterceptor();
        SSOPermissionInterceptor ssoPermissionInterceptor = new SSOPermissionInterceptor();
        ssoPermissionInterceptor.setNothingAnnotationPass(true);
        ssoPermissionInterceptor.setAuthorization(authorization());
        registry.addInterceptor(ssoSpringInterceptor).addPathPatterns("/**");
        registry.addInterceptor(ssoPermissionInterceptor).addPathPatterns("/**");
        registry.addInterceptor(logInterceptor()).addPathPatterns("/**");
        //编码拦截器
        registry.addInterceptor(encodingInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**", "/static/**");
        super.addInterceptors(registry);
    }
}
