package com.zcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//开启服务发现客户端 也就是 nacosServer 的客户端
public class ConfigClientBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBApplication.class, args);
    }

}
