package com.zcf.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: Order
 * Package: com.zcf.pojo
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/6 5:25
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {
    private String id;
    private String name;
    private Double price;
    private Date time;
}
