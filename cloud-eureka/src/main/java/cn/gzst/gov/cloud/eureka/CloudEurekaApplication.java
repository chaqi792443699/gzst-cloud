package cn.gzst.gov.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @description: Eureka注册中心
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaApplication.class, args);
    }
}