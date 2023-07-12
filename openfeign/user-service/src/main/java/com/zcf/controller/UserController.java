package com.zcf.controller;

import com.zcf.feign.UserOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 23:54
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    /**
     * 用户远程调用下单的接口
     *
     * @return
     */
    @GetMapping("userDoOrder")
    public String userDoOrder() {
        String result = userOrderFeign.doOrder();
        System.out.println("result = " + result);
        return result;
    }
}

//调用总结
//user-service --> /userDoOrder --> 通过feign远程调用 /doOrder --> order-service下单成功
