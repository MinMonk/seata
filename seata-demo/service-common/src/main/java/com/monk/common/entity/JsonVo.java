package com.monk.common.entity;

import com.sun.istack.internal.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用响应
 *
 * @author monk
 */
@Data
@NoArgsConstructor
public class JsonVo<T> {

    private Integer code = 200;

    private String message = "success";

    private T data;

    public JsonVo data(@Nullable T data) {
        this.data = data;
        return this;
    }

    public JsonVo(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
