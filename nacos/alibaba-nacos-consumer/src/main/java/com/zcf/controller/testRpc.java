package com.zcf.controller;

import com.zcf.feign.ConsumerProviderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testRpc {

    @Autowired
    private ConsumerProviderFeign consumerProviderFeign;

    /**
     * 测试远程调用
     * @return
     */
    @GetMapping("testRpc")
    public String testRpc() {
        String result = consumerProviderFeign.hello("good good study,day day up!");
        System.out.println("result = " + result);
        return result;
    }
}
