package com.codeashuai.exception;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 11:17
 */
public class MyException extends RuntimeException{
    private String code;
    private String message;

    public MyException(MyExceptionEnum exceptionEnum){
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMeesage();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
