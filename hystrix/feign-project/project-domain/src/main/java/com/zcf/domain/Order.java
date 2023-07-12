package com.zcf.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zcf
 * @Create 2023/7/9 1:16
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private Integer orderId;
    private String name;
    private Double price;
}