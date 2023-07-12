package com.zcf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ProviderServiceController
 * Package: com.zcf.controller
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 5:54
 * @Version 1.0
 */
@RestController
public class ProviderServiceController {
    @GetMapping("info")
    public String info() {
        return "provider-service-info";
    }
}
