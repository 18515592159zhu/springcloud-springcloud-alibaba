package com.zcf.controller;


import com.zcf.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: TestController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 16:46
 * @Version 1.0
 */
@RestController
public class TestController {

    @GetMapping("testGet")
    public String testGet(String name) {
        System.out.println(name);
        return "ok";
    }

    /*
     * post传参有两种：
     * 1.json参数的核心： header content-type = application/json;charset=utf-8
     * 2.接收表单参数：
     *                  <form action=/testPost2
     *                  <input name=ccc value=ssss
     *                  header content-type = application/x-www-form-urlencoded
     * @param user
     * @return
     */
    //1.json参数的核心： header content-type = application/json;charset=utf-8
    @PostMapping("testPost1")
    public String testPost(@RequestBody User user) {
        System.out.println("user = " + user);
        return "ok";
    }

    //2.接收表单参数：
    @PostMapping("testPost2")
    public String testPost2(User user) {
        System.out.println("user = " + user);
        return "ok";
    }
}
