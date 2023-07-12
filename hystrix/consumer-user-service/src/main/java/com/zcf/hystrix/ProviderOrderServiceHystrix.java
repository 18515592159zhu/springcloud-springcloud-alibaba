package com.zcf.hystrix;

import com.zcf.feign.ConsumerProviderFeign;
import org.springframework.stereotype.Component;

/**
 * ClassName: OrderServiceHystrix
 * Package: com.zcf.hystrix
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/8 22:15
 * @Version 1.0
 */
@Component//这里需要加入到IOC容器
public class ProviderOrderServiceHystrix implements ConsumerProviderFeign {
    /**
     * 这个方法是备选方案
     * @return
     */
    @Override
    public String doOrder() {
        System.out.println("调用下单服务失败，我走Hystrix了");
        return "我是Hystrix的doOrder，说明下单失败了";
    }
}
