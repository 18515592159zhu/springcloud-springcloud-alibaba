package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TeacterController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/11 3:15
 * @Version 1.0
 */
@RestController
public class TeacterController {
    @GetMapping("teach")
    public String teach() {
        return "教书学习";
    }
}
