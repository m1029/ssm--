package com.msh.www.http;

/**
 * 状态码的枚举类
 */
public enum AxiosStatus {
    OK(20000,"操作成功"),
    ERROR(50000,"操作失败"),
    EXT_ERROR(30000,"上传格式不支持"),
    FILE_TOLONG(30001,"文件格式过大"),
    NOT_IMAGE(30002,"上传的不是图片"),
    VALID_FAILURE(30004,"表单验证失败"),
    USERENAME_NOT_EMRTY(40002,"用户名不能为空"),
    PASSWORD_NOT_EMPTY(40003,"密码不能为空"),
    USERENAME_NOT_SURE(40004,"用户名不正确"),
    PASSWORD_NOT_SURE(40005,"密码不正确"),
    TOKEN_ERROR(40006,"token不正确")
    ;

    private int status;

    private String message;

    AxiosStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
