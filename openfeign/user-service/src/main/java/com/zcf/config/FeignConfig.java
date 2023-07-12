package com.zcf.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: FeignConfig
 * Package: com.zcf.config
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/8 21:04
 * @Version 1.0
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}
