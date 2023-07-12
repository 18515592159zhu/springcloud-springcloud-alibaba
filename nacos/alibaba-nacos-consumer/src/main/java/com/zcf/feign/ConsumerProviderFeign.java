package com.zcf.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: ConsumerProviderFeign
 * Package: com.zcf.feign
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/10 4:55
 * @Version 1.0
 */
@FeignClient(value = "alibaba-nacos-provider")
public interface ConsumerProviderFeign {
    /**
     * 远程调用打招呼接口
     * @param name
     * @return
     */
    @GetMapping("hello")
    public String hello(@RequestParam("name") String name);
}
