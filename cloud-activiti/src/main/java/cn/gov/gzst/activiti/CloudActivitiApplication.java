package cn.gov.gzst.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.activiti
 * @title:
 * @description: 流程设计启动类
 * @author: jianliaoliang
 * @date: 2018/2/22 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@ComponentScan({"org.activiti.rest.diagram","cn.gov.gzst.activiti"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"cn.gov.gzst.admin"})
@EnableCircuitBreaker
@EnableScheduling        //使能定时任务
@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
        ,org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class CloudActivitiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudActivitiApplication.class, args);
    }
}
