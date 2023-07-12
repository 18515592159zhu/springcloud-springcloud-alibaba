package com.zcf.feign;

import com.zcf.domain.Order;
import com.zcf.feign.hystrix.UserOrderFeignhystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: UserOrderFeign
 * Package: com.zcf.feign
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 1:19
 * @Version 1.0
 */
@FeignClient(value = "order-center",fallback = UserOrderFeignhystrix.class)
public interface UserOrderFeign {
    /**
     * 查询订单
     */
    @GetMapping("/order/getOrderByUserId")
    public Order getOrderByUserId(@RequestParam Integer userId);
}
