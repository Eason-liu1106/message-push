package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author LJL
 * @date 2018/5/23 0023 20:06
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = "com.*")
@Configuration
@EnableDiscoveryClient
public class MailApplication {
    public static void main(String[] args){
        SpringApplication.run(MailApplication.class, args);

    }
}
