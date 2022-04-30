package com.monk.common.constant;

import lombok.Getter;

@Getter
public enum ErrorCodeEnum {


    BUSINESS_ERROR(10000, "系统错误"),
    DATA_NOT_FOUNT(10001, "数据未找到"),
    INSUFFICIENT_FUND(10002, "余额不足"),
    INSUFFICIENT_INVENTORY(10003, "库存不足"),
    SYSTEM_ERROR(500, "系统错误");

    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
