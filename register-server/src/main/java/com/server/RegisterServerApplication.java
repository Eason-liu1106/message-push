package com.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author LJL
 * @date 2018/5/23 0023 20:06
 */
@Configuration
@SpringBootApplication
@EnableEurekaServer
public class RegisterServerApplication {
    public static void main(String[] args){
        SpringApplication.run(RegisterServerApplication.class, args);

    }
}
