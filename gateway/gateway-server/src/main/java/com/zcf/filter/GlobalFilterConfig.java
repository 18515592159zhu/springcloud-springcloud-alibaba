package com.zcf.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 定义一个过滤器
 */
//@Component
@Slf4j
public class GlobalFilterConfig implements GlobalFilter, Ordered {

    /**
     * 这个就是过滤器的方法
     * 过滤器链模式
     * 责任链模式
     * 网关里面有使用 mybatis的二级缓存有变种责任链模式
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入了我自己的全局过滤器");
        //针对请求的过滤 拿到请求 header url 参数 ....
        ServerHttpRequest request = exchange.getRequest();
        //HttpServletRequest  这个是web里面的
        //ServerHttpRequest  webFlux里面 响应式里面的
        String path = request.getURI().getPath();
        System.out.println("path = " + path);//   /user-service-router/info
        HttpHeaders headers = request.getHeaders();
        System.out.println("headers = " + headers);
        String methodName = request.getMethod().name();
        System.out.println("methodName = " + methodName);//   methodName = GET
        String ip = request.getHeaders().getHost().getHostString();
        System.out.println("ip = " + ip);//   ip = localhost
        // 响应相关的数据
        ServerHttpResponse response = exchange.getResponse();
        //用了微服务 肯定是前后端分离的 前后端分离 一般前后通过 json
        //{"code":200,"msg":"ok"}
        //设置编码 响应头里面置
//        response.getHeaders().set("content-type", "application/json;charset=utf-8");
//        //组装业务返回值
//        HashMap<String, Object> map = new HashMap<>(4);
//        map.put("code", HttpStatus.UNAUTHORIZED.value());
//        map.put("msg", "你未授权");
//        ObjectMapper objectMapper = new ObjectMapper();
//        //把一个map转成一个字节
//        byte[] bytes = new byte[0];
//        try {
//            bytes = objectMapper.writeValueAsBytes(map);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        //通过buffer工厂将字节数组包装成 一个数据包
//        DataBuffer wrap = response.bufferFactory().wrap(bytes);
//        return response.writeWith(Mono.just(wrap));
        //放行 到下一个过滤器了
        return chain.filter(exchange);
    }

    /**
     * order 越小 越先执行
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
