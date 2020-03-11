package cn.gov.gzst.pms;

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
 * @package  cn.gov.gzst.pms
 * @title:
 * @description: 调查问卷系统启动
 * @author: 吴正军
 * @date: 2019/3/11 12:35
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableScheduling        //使能定时任务
@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class})
public class CloudPmsApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudPmsApplication.class, args);
    }
}
