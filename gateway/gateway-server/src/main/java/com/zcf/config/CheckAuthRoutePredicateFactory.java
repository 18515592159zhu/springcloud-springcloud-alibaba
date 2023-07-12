package com.zcf.config;

import lombok.Data;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * ClassName: CheckAuthRoutePredicateFactory
 * Package: com.zcf.config
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/9 8:26
 * @Version 1.0
 */
//@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            System.err.println("进入了 CheckAuthRoutePredicateFactory\t" +
                    config.getName());
            if (config.getName().equals("xiaobai")) {
                return true;
            }
            return false;
        };
    }

    @Data
    static class Config {
        private String name;
    }
}