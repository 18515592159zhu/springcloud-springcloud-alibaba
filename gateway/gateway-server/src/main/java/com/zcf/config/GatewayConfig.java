package com.zcf.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: GatewayConfig
 * Package: com.zcf.config
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 6:50
 * @Version 1.0
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes
                .route("path_rote_guonei", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("path_rote_guoji", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
                .route("path_rote_tech", r -> r.path("/tech").uri("http://news.baidu.com/tech"))
                .route("path_rote_lady", r -> r.path("/lady").uri("http://news.baidu.com/lady"))
                .build();
        return routes.build();
    }
}
