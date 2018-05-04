package com.exercise.exercise.exception;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public enum  CustomError {

    SESSION_TIMEOUT(1, "会话过期"),

    SESSION_NOT_FOUND(2, "会话不存在"),

    USER_NOT_EXIST(3,"用户不存在"),

    PASSWORD_ERROR(4,"密码错误"),

    USERNAME_EXIST(5,"用户名已被注册"),

    EMAIL_ILLEGAL(6,"邮箱不合法"),

    GENDER_ILLEGAL(7,"性别不合法"),

    PASSWORD_ILLEGAL(8,"密码不合法"),

    PEOPLE_ILLEGAL(9,"人数不合法"),

    JOIN_ALREADY(10,"已经参加了活动"),


    ;


    private int code;

    private String errMsg;

    CustomError(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    CustomError() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
