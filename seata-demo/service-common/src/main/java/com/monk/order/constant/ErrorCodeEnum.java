package com.monk.order.constant;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {


    BUSINESS_ERROR(10000, "系统错误"),
    SYSTEM_ERROR(500, "系统错误");

    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
