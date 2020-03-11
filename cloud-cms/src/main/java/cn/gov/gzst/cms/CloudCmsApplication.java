package cn.gov.gzst.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @version V1.0
 * @description: 科技云内容管理系统启动
 * @author: jianliaoliang
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableScheduling        //使能定时任务
@EnableFeignClients(basePackages = {"cn.gov.gzst.sso","cn.gov.gzst.admin"})
@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class})
public class CloudCmsApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(CloudCmsApplication.class, args);
    }
}
