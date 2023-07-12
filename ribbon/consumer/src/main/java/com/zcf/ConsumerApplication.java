package com.zcf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    /**
     * 这个RestTemplate 已经变了
     * LoadBalanced 他就会被ribbon来操作
     */
    @Bean
    @LoadBalanced//ribbon 的负载均衡注解
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //配置此消费者调用任何服务都用某种算法
    @Bean
    public IRule myRule() {
        //指定调用所有的服务都用此算法
        return new RandomRule();
    }
}
