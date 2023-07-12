package com.zcf.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * ClassName: BaseResult
 * Package: com.zcf.base
 * Description:
 *
 * @Author zcf
 * @Create 2023/7/8 8:42
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseResult implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public static BaseResult success(Integer code, String msg, Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(code);
        baseResult.setData(data);
        baseResult.setMsg(msg);
        return baseResult;
    }
}
