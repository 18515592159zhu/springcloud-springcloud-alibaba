package com.zcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: ConsumerController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/10 4:22
 * @Version 1.0
 */
@RestController
public class ConsumerController {

    //注入服务发现组件 在Eureka中也用到过
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("discovery")
    public String discoveryService(String serviceName) {
        //根据实例名称拿到实例集合
        List<ServiceInstance> instanceList = discoveryClient.getInstances(serviceName);
        //从实例集合列表中获取一个实例对象
        ServiceInstance instance = instanceList.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        System.out.println("host = " + host + " port = " + port);
        return instance.getHost() + ":" + instance.getPort();
    }
}