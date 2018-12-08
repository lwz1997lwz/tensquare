package com.tensquare.base.com.tensquare.base.exception;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: tensquare_parent
 * @description: Base模块全局异常处理器
 * @author: Linweizhe
 * @create: 2018-12-06 19:14
 **/
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
