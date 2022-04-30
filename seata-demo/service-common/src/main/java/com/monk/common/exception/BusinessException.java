package com.monk.common.exception;

import com.monk.common.constant.ErrorCodeEnum;
import lombok.Data;

/**
 * @author monk
 */
@Data
public class BusinessException extends RuntimeException{

    private int code;

    private String msg;

    public BusinessException(int code, String msg){
        super();
        this.msg = msg;
        this.code = code;
    }

    public BusinessException(ErrorCodeEnum errorCodeEnum){
        super();
        this.msg = errorCodeEnum.getMsg();
        this.code = errorCodeEnum.getCode();
    }
}
