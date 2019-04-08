package com;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author LJL
 * @date 2018/5/23 0023 20:06
 */
@EnableAdminServer
@Configuration
@SpringBootApplication
@EnableDiscoveryClient
public class ServerApplication {
    public static void main(String[] args){
        SpringApplication.run(ServerApplication.class, args);

    }
}
