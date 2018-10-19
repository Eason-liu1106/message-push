package com;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author LJL
 * @date 2018/5/23 0023 20:06
 */
//@EnableAdminServer
//@Configuration
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = "com.*")
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class, args);

    }
}
