package com.zcf.controller;

import com.zcf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.UUID;

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

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("doLogin")
    public String doLogin(String name, String password) {
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        // 这里假设做了登录
        User user = new User(1, name, password, 18);
        // token
        String token = UUID.randomUUID().toString();
        //存起来
        redisTemplate.opsForValue().set(token, user.toString(), Duration.ofSeconds(7200));
        return token;
    }

    @GetMapping("info")
    public String info() {
        return "user-service-info";
    }
}