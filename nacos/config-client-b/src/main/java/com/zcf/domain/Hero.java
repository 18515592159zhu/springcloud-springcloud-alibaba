package com.zcf.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * ClassName: Hero
 * Package: com.zcf.domain
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/10 7:36
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component //添加到 IOC 中，一会在 controller 注入
@RefreshScope //刷新的域，当配置文件修改后可以动态刷新
public class Hero {

    @Value("${hero.name}")
    private String name;
    @Value("${hero.age}")
    private Integer age;
    @Value("${hero.address}")
    private String address;
}