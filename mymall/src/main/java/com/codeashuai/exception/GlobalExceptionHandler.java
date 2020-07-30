package com.codeashuai.exception;

import com.codeashuai.entity.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 11:12
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 此类是用于捕获到特定异常后返回JSON到页面
     * 可以返回到指定页面并渲染特定错误数据
     * @param: m
     * @return
     */
    @ExceptionHandler(MyException.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleMyexception(MyException m){
        String code = m.getCode();
        String message = m.getMessage();
        log.warn("异常发生: 状态码：{}，信息：{}",code,message);
        return new Result<String>(code,message,"返回的结果信息");
    }

    /*@ExceptionHandler(Exception.class)
    public Result handleMyexception2(Exception m){
//        String code = m.getCode();
        String message = m.getMessage();
        log.warn("异常发生: 信息：{}",message);
        return new Result<String>(401+"",message,"返回的结果信息");
    }*/
}
