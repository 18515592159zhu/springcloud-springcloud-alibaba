package com.zcf.controller;

import com.zcf.domain.Order;
import com.zcf.feign.UserOrderFeign;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 1:30
 * @Version 1.0
 */
@RestController
public class OrderController implements UserOrderFeign {

    @Override
    public Order getOrderByUserId(Integer userId) {
        System.out.println("userId = " + userId);
        Order order = Order.builder()
                .name("小白熊")
                .price(17D)
                .orderId(11)
                .build();
        return order;
    }
}
