package com.zcf.controller;

import com.zcf.feign.ConsumerProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: ConsumerController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/8 22:48
 * @Version 1.0
 */
@RestController
public class ConsumerController {

    /**
     * @Resource是Java自己的注解：@Resource有两个属性是比较重要的，分别是name和type，默认按byName进行注入
     * @@AutoWired是spring的注解：默认的注入方式为byType（根据类型进行匹配）另外，如果type无法辨别注入对象时，也可以配合@Qualifier或@Primary注解来分辨注入类
     */
    @Autowired
    private ConsumerProviderFeign consumerProviderFeign;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 用户远程调用下单的接口
     */
    @GetMapping("userDoOrder")
    public String userDoOrder() {
        // RPC
        String result = consumerProviderFeign.doOrder();
        return result;
    }
}
