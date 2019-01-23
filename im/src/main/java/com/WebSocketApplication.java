package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 描述:
 *
 * @author LJL
 * @date 2018/5/23 0023 20:06
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class},scanBasePackages = "com.*")
//@Configuration
//@EnableAutoConfiguration
public class WebSocketApplication {
    public static void main(String[] args){
        SpringApplication.run(WebSocketApplication.class, args);

    }
}
