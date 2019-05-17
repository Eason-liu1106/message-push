package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;

/**
 * 描述:
 *
 * @author LJL
 * @date 2018/5/23 0023 20:06
 */
@SpringBootApplication(scanBasePackages = {"com.*"}, exclude = {SecurityAutoConfiguration.class})
@EnableDiscoveryClient
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);

    }
}
