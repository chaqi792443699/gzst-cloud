package cn.gov.gzst.sso.server.config;

import cn.gov.gzst.common.jcaptcha.JCaptchaFilter;
import cn.gov.gzst.common.utils.EasyDateFormat;
import cn.gov.gzst.common.utils.SpringContextHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 初始化相关配置
 */
@ControllerAdvice
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);
    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JCaptchaFilter jcaptchaFilter = new JCaptchaFilter();
        registrationBean.setFilter(jcaptchaFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/jcaptcha.jpg");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

    /**
     * 解决解析日期报错
     * @param jackson2ObjectMapperBuilder
     * @return
     */
    @Bean
    public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
        ObjectMapper mapper = jackson2ObjectMapperBuilder.build();
        // ObjectMapper为了保障线程安全性，里面的配置类都是一个不可变的对象
        // 所以这里的setDateFormat的内部原理其实是创建了一个新的配置类
        DateFormat dateFormat = mapper.getDateFormat();
        mapper.setDateFormat(new EasyDateFormat(dateFormat));
        MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(
                mapper);
        return mappingJsonpHttpMessageConverter;
    }
}