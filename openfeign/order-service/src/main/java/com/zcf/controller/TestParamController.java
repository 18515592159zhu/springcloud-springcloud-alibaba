package com.zcf.controller;

import com.zcf.base.BaseResult;
import com.zcf.pojo.Order;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * ClassName: TestParamController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/6 5:26
 * @Version 1.0
 * feign传参确保消费者和提供者的参数列表保持一致，包括返回值 方法签名要一致
 * 1.通过URL传参数，get请求，参数列表使用@PathVariable("")
 * 2.如果是GET请求，每个基本参数必须加@RequestParam("")
 * 3.如果是POST请求，而且是对象集合等参数，必须加@Requestbody或者@RequestParam("")
 */
@RestController
public class TestParamController {

    /**
     * 测试单个参数
     */
    @GetMapping("testOneParam")
    public BaseResult oneParam(@RequestParam("name") String name) {
        System.out.println("name = " + name);
        return BaseResult.success(200, "成功", "ok");
    }

    /**
     * 测试两个参数
     */
    @GetMapping("testTwoParam")
    public BaseResult twoParam(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("name = " + name + " age = " + age);
        return BaseResult.success(200, "ok", "ok");
    }

    /**
     * 测试一个对象的传参
     */
    @PostMapping("testObjectParam")
    public BaseResult objectParam(@RequestBody Order order) {
        System.out.println("order = " + order);
        return BaseResult.success(200, "ok", order);
    }

    /**
     * 测试一个对象一个参数
     */
    @PostMapping("testOneObjectOneParam")
    public BaseResult OneObjectOneParam(@RequestBody Order order, @RequestParam("name") String name) {
        System.out.println("order = " + order + " name = " + name);
        return BaseResult.success(200, "ok", order);
    }

    /**
     * 测试url传参
     */
    @GetMapping("testUrlParam/{id}")
    public BaseResult testUrlParam(@PathVariable("id") Integer id) {
        System.out.println("id = " + id);
        return BaseResult.success(200, "ok", id);
    }

    /**
     * 单独传递时间对象
     */
    @GetMapping("testTime")
    public String testTime(@RequestParam Date date) {
        System.out.println("date = " + date);
        return "ok";
    }
}