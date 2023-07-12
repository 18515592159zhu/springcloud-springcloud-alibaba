package com.zcf.controller;

import com.zcf.base.BaseResult;
import com.zcf.feign.UserOrderFeign;
import com.zcf.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName: TestController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/6 5:46
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private UserOrderFeign userOrderFeign;

    @RequestMapping("testFeignParam")
    public String testFeignParam() {

        //测试单个参数
        BaseResult result1 = userOrderFeign.oneParam("朱驰峰");
        System.out.println("result1 = " + result1);
        System.out.println("--------------------------------------------------");

        //测试两个参数
        BaseResult result2 = userOrderFeign.twoParam("张三丰", 88);
        System.out.println("result2 = " + result2);
        System.out.println("--------------------------------------------------");

        //测试一个对象的传参
        Order order = Order.builder()
                .id("111")
                .name("张无忌")
                .price(10000D)
                .time(new Date())
                .build();
        BaseResult result3 = userOrderFeign.objectParam(order);
        System.out.println("result3 = " + result3);
        System.out.println("--------------------------------------------------");

        //测试一个对象一个参数
        BaseResult result4 = userOrderFeign.OneObjectOneParam(order, "赵敏");
        System.out.println("result4 = " + result4);
        System.out.println("--------------------------------------------------");

        //测试URL传参
        BaseResult result5 = userOrderFeign.testUrlParam(888);
        System.out.println("result5 = " + result5);
        System.out.println("--------------------------------------------------");

        return "ok";
    }

    /*
     * 时间日期参数问题
     * Sun Mar 20 10:24:13 CST 2022
     * Mon Mar 21 00:24:13 CST 2022  +- 14个小时
     * 1.不建议单独传递时间参数
     * 2.转成字符串   2022-03-20 10:25:55:213 因为字符串不会改变
     * 3.jdk LocalDate 年月日    LocalDateTime 会丢失s
     * 4.改feign的源码
     */
    @GetMapping("time")
    public String time() {
        Date date = new Date();
        System.out.println("date = " + date);
        String s = userOrderFeign.testTime(date);
        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        return s;
    }
}
