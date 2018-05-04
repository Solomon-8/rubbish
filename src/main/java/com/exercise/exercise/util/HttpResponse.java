package com.exercise.exercise.util;

/**
 * @author Solomon
 * @date 2018/4/29
 */
public class HttpResponse<T> {
    private boolean success;

    private String errMessage;

    private Integer errCode;

    private T data;

    public HttpResponse(boolean success, String errMessage, Integer errCode, T data) {
        this.success = success;
        this.errMessage = errMessage;
        this.errCode = errCode;
        this.data = data;
    }

    public HttpResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> HttpResponse success(T data) {
        return new HttpResponse<>(true, null, null, data);
    }

    public static HttpResponse<Void> failure(String errMsg, Integer errCode) {
        return new HttpResponse<>(false, errMsg, errCode, null);
    }
}
