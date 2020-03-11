package cn.gzst.gov.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 * @package cn.gzst.gov.cloud.gateway
 * @title:
 * @description: 服务网关
 */

@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages = {"cn.gov.gzst.admin"})
@SpringBootApplication(exclude={ActiveMQAutoConfiguration.class})
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }
}
