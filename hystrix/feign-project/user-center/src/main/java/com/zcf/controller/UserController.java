package com.zcf.controller;

import com.zcf.domain.Order;
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
 * @Create 2023/7/9 1:40
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    public UserOrderFeign userOrderFeign;

    @GetMapping("find")
    public Order findOrder() {
        return userOrderFeign.getOrderByUserId(1);
    }
}