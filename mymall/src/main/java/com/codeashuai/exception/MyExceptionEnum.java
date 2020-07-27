package com.codeashuai.exception;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/24 11:25
 */
public enum MyExceptionEnum {

    SYSTEM_Exception("500","系统异常，请联系管理员！"),
    AUTHORITY_Exception("401","权限不足,操作失败");


    private String code;
    private String meesage;

    MyExceptionEnum(String code, String meesage) {
        this.code = code;
        this.meesage = meesage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMeesage() {
        return meesage;
    }

    public void setMeesage(String meesage) {
        this.meesage = meesage;
    }
}
