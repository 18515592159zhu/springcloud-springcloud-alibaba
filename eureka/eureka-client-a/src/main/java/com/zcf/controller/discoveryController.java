package com.zcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: discoveryController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 1:37
 * @Version 1.0
 */
@RestController
public class discoveryController {

    //注入服务发现组件，我们的eureka已经实现了这个接口，所以IOC里面有这个对象
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 什么是服务发现：根据服务名称发现服务的实例的过程，客户端会在本地缓存服务端的列表
     * 访问 http://localhost:8080/test?serviceName=eureka-client-b
     * @param serviceName
     * @return
     */
    @GetMapping("test")
    public String doDiscovery(String serviceName) {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceName);
        serviceInstanceList.forEach(System.out::println);
        ServiceInstance serviceInstance = serviceInstanceList.get(0);
        String ip = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        System.out.println(ip + ":" + port);
        return serviceInstanceList.get(0).toString();
    }
}
