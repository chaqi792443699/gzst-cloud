package cn.gov.gzst.monitor.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * All rights Reserved, Designed By www.gzst.gov.cn
 *
 * @version V1.0
 * @package cn.gov.gzst.monitor.service.admin
 * @title:
 * @description: 启动类
 * @author: jianliaoliang
 * @date: 2018/4/2 14:42
 * @copyright: 2017 www.gzst.gov.cn Inc. All rights reserved.
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, ActiveMQAutoConfiguration.class})
public class CloudMonitorAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudMonitorAdminApplication.class, args);
    }
}
