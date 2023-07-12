package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserServiceController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 5:53
 * @Version 1.0
 */
@RestController
public class UserServiceController {
    @GetMapping("info")
    public String info() {
        return "user-service-info-1";
    }
}