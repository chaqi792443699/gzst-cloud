package cn.gov.gzst.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package  cn.gov.gzst.admin
 * @title:
 * @description: 科技云邮件系统启动
 * @author: jianliaoliang
 * @date: 2018/2/22 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages={"cn.gov.gzst.admin"})
@EnableCircuitBreaker
@EnableScheduling        //使能定时任务
@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class})
public class CloudEmailApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudEmailApplication.class, args);
    }
}
