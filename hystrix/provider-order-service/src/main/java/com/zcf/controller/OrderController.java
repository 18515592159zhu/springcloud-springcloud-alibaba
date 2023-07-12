package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/8 22:04
 * @Version 1.0
 */
@RestController
public class OrderController {
    /**
     * 订单服务下单接口
     */
    @GetMapping("doOrder")
    public String doOrder() {
        System.out.println("有用户来下单了");
        return "下单成功";
    }
}