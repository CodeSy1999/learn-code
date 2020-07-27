package com.codeashuai.entity;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 11:06
 */
public class Result<T> {

    private String code;
    private String message;
    private T result;

    public Result() {
    }

    public Result(String code) {
        this.code = code;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
