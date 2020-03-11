package cn.gzst.gov.cloud.gateway.config;

import cn.gov.gzst.common.utils.SpringContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 初始化相关配置
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}