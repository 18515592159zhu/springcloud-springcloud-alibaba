package com.zcf.feign;

import com.zcf.base.BaseResult;
import com.zcf.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * ClassName: UserOrderFeign
 * Package: com.zcf.feign
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/5 23:55
 * @Version 1.0
 * @FeignClient 声明是 feign 的调用
 * value = "order-service" value 后面的值必须和提供者的服务名一致
 */
@FeignClient(value = "order-service")
public interface UserOrderFeign {

    /**
     * 描述：下单的方法：这里的路径必须和提供者的路径一致
     * 远程调用下单的方法
     * @return java.lang.String
     */
    @GetMapping("doOrder")
    public String doOrder();

    //=======================================================
    //你需要调用哪个controller  就写它的方法签名
    //方法签名(就是包含一个方法的所有的属性)


    /**
     * 测试单个参数
     */
    @GetMapping("testOneParam")
    public BaseResult oneParam(@RequestParam("name") String name);

    /**
     * 测试两个参数
     */
    @GetMapping("testTwoParam")
    public BaseResult twoParam(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "age", required = false) Integer age);


    /**
     * 测试一个对象的传参
     */
    @PostMapping("testObjectParam")
    public BaseResult objectParam(@RequestBody Order order);

    /**
     * 测试一个对象一个参数
     */
    @PostMapping("testOneObjectOneParam")
    public BaseResult OneObjectOneParam(@RequestBody Order order, @RequestParam("name") String name);

    /**
     * 测试url传参
     */
    @GetMapping("testUrlParam/{id}")
    public BaseResult testUrlParam(@PathVariable("id") Integer id);

    /**
     * 单独传递时间对象
     */
    @GetMapping("testTime")
    public String testTime(@RequestParam Date date);
}