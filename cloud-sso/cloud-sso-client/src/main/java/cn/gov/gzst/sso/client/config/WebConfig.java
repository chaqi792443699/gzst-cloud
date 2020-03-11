package cn.gov.gzst.sso.client.config;

import cn.gov.gzst.common.jcaptcha.JCaptchaFilter;
import cn.gov.gzst.common.utils.SpringContextHolder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.dataact.spring
 * @title:
 * @description: WEB 初始化相关配置
 * @author: jianliaoliang
 * @date: 2018/2/22 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */

@ControllerAdvice
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

}