package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProviderController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/10 4:19
 * @Version 1.0
 */
@RestController
public class ProviderController {
    /**
     * 打招呼的接口
     *
     * @param name
     * @return
     */
    @GetMapping("hello")
    public String hello(String name) {
        return "hello:" + name + " 8083";
    }
}
