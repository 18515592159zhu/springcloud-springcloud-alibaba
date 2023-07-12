package com.zcf.feign.hystrix;

import com.zcf.domain.Order;
import com.zcf.feign.UserOrderFeign;
import org.springframework.stereotype.Component;

/**
 * ClassName: UserOrderFeignhystrix
 * Package: com.zcf.feign.hystrix
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 1:20
 * @Version 1.0
 */
@Component //这里需要加入到IOC容器
public class UserOrderFeignhystrix implements UserOrderFeign {

    /**
     * 这个方法是备选方案
     * 一般远程调用的熔断可以直接返回null
     */
    @Override
    public Order getOrderByUserId(Integer userId) {
        return null;
    }
}
