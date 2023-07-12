package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProviderController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 17:44
 * @Version 1.0
 */
@RestController
public class ProviderController {
    @GetMapping("info")
    public String info() {
        return "我是provider-2";
    }
}
