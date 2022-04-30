package com.monk.storage.handler;

import com.monk.common.constant.ErrorCodeEnum;
import com.monk.common.entity.JsonVo;
import com.monk.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author monk
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    JsonVo handBusinessException(BusinessException exception){
        return new JsonVo(exception.getCode(), exception.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    JsonVo handBusinessException(RuntimeException exception){
        return new JsonVo(ErrorCodeEnum.SYSTEM_ERROR.getCode(), exception.getMessage());
    }
}
