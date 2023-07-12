package com.zcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserServiceRouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceRouterApplication.class, args);
    }

}
