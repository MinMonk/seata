package com.monk.order.exception;

import com.monk.order.constant.ErrorCodeEnum;

/**
 * @author monk
 */
public class BusinessException extends RuntimeException{

    private int code;

    private String msg;

    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getMsg());
        this.code = errorCodeEnum.getCode();
    }
}
