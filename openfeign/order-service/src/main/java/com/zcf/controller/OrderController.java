package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: OrderController
 * Package: com.zcf.orderservice.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 23:52
 * @Version 1.0
 */
@RestController
public class OrderController {

    /**
     * 订单服务下单接口
     * @return
     */
    @GetMapping("doOrder")
    public String doOrder() {
        //因为ribbon默认调用时长为1秒，可以修改超时时长
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("有用户来下单了");
        return "下单成功！";
    }
}