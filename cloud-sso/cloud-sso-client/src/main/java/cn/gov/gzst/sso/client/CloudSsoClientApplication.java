package cn.gov.gzst.sso.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.spring.cloud.demo.service.eureka.consumer
 * @title:
 * @description: 单点登录客户端测试
 * @author: jianliaoliang
 * @date: 2018/3/13 10:08
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class,ActiveMQAutoConfiguration.class})
public class CloudSsoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudSsoClientApplication.class,args);
    }
}
