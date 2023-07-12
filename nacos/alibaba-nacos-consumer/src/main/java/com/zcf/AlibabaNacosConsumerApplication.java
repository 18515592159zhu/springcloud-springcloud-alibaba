package com.zcf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient //开启服务发现客户端 也就是 nacosServer 的客户端
@EnableFeignClients //开启 feign 的客户端
public class AlibabaNacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaNacosConsumerApplication.class, args);
    }

}
