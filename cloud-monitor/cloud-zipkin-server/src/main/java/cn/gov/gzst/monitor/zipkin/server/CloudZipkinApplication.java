package cn.gov.gzst.monitor.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.monitor.zipkin.server
 * @title:
 * @description:  Spring Cloud Sleuth和Zipkin进行分布式链路跟踪
 * @author: jianliaoliang
 * @date: 2018/4/3 11:25
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class CloudZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZipkinApplication.class, args);
    }

}
