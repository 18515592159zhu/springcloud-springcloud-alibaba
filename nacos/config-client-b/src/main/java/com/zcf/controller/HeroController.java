package com.zcf.controller;

import com.zcf.domain.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HeroController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/10 7:40
 * @Version 1.0
 */
@RestController
public class HeroController {

    /**
     * 注入 hero
     */
    @Autowired
    private Hero hero;

    /**
     * 获取信息的接口
     * @return
     */
    @GetMapping("heroInfo")
    public String heroInfo() {
        return hero.getName() + ":" + hero.getAge() + ":" + hero.getAddress();
    }
}
