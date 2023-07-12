package com.zcf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

/**
 * ClassName: TestController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 17:49
 * @Version 1.0
 */
@RestController
public class TestController {
    @Autowired
    private RestTemplate restTemplate;

    /*
     * 思考：ribbon是怎么将 http://provider/info 路径请求成功的
     * http://127.0.0.1:8081/info
     * 1。拦截这个请求
     * 2.获取该请求的URL地址:http://provider/info
     * 3.截取URL中的provider
     * 4、借助eureka来做服务发现 从服务列表中找到key为provider的服务实例的集合
     * 5.通过负载均衡算法 选出一个符合的实例
     * 6.拿到该实例的host和port 重构原来URL中的provider
     * 7.真正的发送 restTemplate.getForObject(“http://ip:port/info”，String.class)
     *
     * @param serviceName
     * @return
     */
    //测试ribbon的负载均衡
    @GetMapping("testRibbon")
    public String testRibbonBalance(String serviceName) {
        // 正常来讲，需要拿到ip和port以及路径才可以访问
        // http://provider/info
        String url = "http://" + serviceName + "/info";
        String result = restTemplate.getForObject(url, String.class);
        //只要你给restTemplate加了ribbon的注解，项目中这个对象发起的请求都会走ribbon的代理
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject("http://localhost:8888/aaaa", String.class);
        return result;
    }


    @Autowired
    private DiscoveryClient discoveryClient;

    static Random random = new Random();

    //不使用ribbon
    @GetMapping("testBalance")
    public String testBalance(String serviceName) {
        //获取服务列表
        List<ServiceInstance> instanceList = discoveryClient.getInstances(serviceName);
        if (ObjectUtils.isEmpty(instanceList)) {
            return "服务列表为空";
        }
        //如果服务列表不为空，先自己做一个负载均衡
        ServiceInstance serviceInstance = loadBalance(instanceList);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        String url = "http://" + host + ":" + port + "/info";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("result = " + result);
        return result;
    }

    private ServiceInstance loadBalance(List<ServiceInstance> instanceList) {
        //拼接url去调用 ip:port 先自己实现不用ribbon
        ServiceInstance serviceInstance = instanceList.get(random.nextInt(instanceList.size()));
        return serviceInstance;
    }

    // 轮训的算法 怎么去实现
    // 两台机器   A B
    // A
    // B
    // A
    // B
    // 代码实现轮训的算法  List<机器>
    // 请求次数
    //  int index =   1 % size    list.get(index);
    // % 取模 取余好处是一个周期函数 让得到的结果 总是小于 除数的
    //  1 / 2    1 % 2
    // 1%2=1
    // 2%2=0
    // 3%2=1
    // 4%2=0
    // 全局顶一个int i = 0
    // i++  线程不安全的
    // i % size
    // 怎么能做一个线程安全的轮训算法   加锁 效率极低  CAS 自旋锁 没有线程的等待和唤醒的开销
    // CAS 优点 性能好 java层面无锁的状态  但是在jvm层面 有锁的cmpxchg
    // CAS 缺点 会导致短暂时间内 CPU 飙升  还有ABA 问题

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //Ribbon 负载均衡的测试
    @GetMapping("testChoose")
    public String testChoose(String serviceName) {
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
        System.out.println("host = " + serviceInstance.getHost());
        System.out.println("port = " + serviceInstance.getPort());
        return serviceInstance.toString();
    }




}