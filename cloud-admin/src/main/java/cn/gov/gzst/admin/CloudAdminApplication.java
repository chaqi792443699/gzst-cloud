package cn.gov.gzst.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package  cn.gov.gzst.admin
 * @title:
 * @description: 科技云后台系统启动
 * @date: 2018/2/22 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@ComponentScan({"cn.gov.gzst.common","cn.gov.gzst.admin"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.gov.gzst.activiti","cn.gov.gzst.admin","cn.gov.gzst.sms","cn.gov.gzst.email"})
@EnableCircuitBreaker
@EnableScheduling        //使能定时任务
@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class})
public class CloudAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudAdminApplication.class, args);
    }
}
