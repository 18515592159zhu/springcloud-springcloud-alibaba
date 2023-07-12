package com.zcf.feign;

import com.zcf.hystrix.ProviderOrderServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 这里需要指定熔断的类
 */
@FeignClient(value = "provider-order-service",fallback = ProviderOrderServiceHystrix.class)
public interface ConsumerProviderFeign {
    /**
     * 订单服务下单接口
     */
    @GetMapping("doOrder")
    public String doOrder();
}
