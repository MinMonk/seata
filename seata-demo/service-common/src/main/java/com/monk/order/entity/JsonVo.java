package com.monk.order.entity;

import lombok.Data;

/**
 * 通用响应
 * @author monk
 */
@Data
public class JsonVo<T> {

    private Integer code = 200;

    private String message = "success";

    private T data;

    public JsonVo data(T data){
        this.data = data;
        return this;
    }
}
