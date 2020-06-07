package com.qy.base.controller;

import com.qy.base.comm.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * Fegin响应结果
 */
@Data
public class FeginResponse<T> implements Serializable {

    private int status;
    private T data;
    private String message;
    private boolean isSuccess;


    private FeginResponse(int status, boolean isSuccess) {
        this.status = status;
        this.isSuccess = isSuccess;
    }


    private FeginResponse(int status, T data, boolean isSuccess) {
        this.status = status;
        this.data = data;
        this.isSuccess = isSuccess;
    }


    private FeginResponse(int status, String message, boolean isSuccess) {
        this.status = status;
        this.message = message;
        this.isSuccess = isSuccess;
    }

    private FeginResponse(int status, String message, T data, boolean isSuccess) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.isSuccess = isSuccess;
    }

    private FeginResponse(String message, T data, boolean isSuccess) {
        this.message = message;
        this.data = data;
        this.isSuccess = isSuccess;
    }

    /**
     * 创建返回成功的对象
     *
     * @return
     */
    public static <T> FeginResponse<T> createBySuccess(String message, T data) {
        return new FeginResponse(ResponseCode.SUCCESS.getCode(), message, data, true);
    }

    public static <T> FeginResponse<T> createBySuccess(int code, String message) {
        return new FeginResponse(code, message, true);
    }

    public static <T> FeginResponse<T> createBySuccess(int code, String message, T data) {
        return new FeginResponse<>(code, message, data, true);
    }

    public static <T> FeginResponse<T> createBySuccess() {
        return new FeginResponse<>(ResponseCode.SUCCESS.getCode(), true);
    }

    public static <T> FeginResponse<T> createBySuccess(String message) {
        return new FeginResponse<>(ResponseCode.SUCCESS.getCode(), message, true);
    }

    public static <T> FeginResponse<T> createBySuccess(T data) {
        return new FeginResponse<>(ResponseCode.SUCCESS.getCode(), data, true);
    }

    /**
     * 创建返回失败的对象
     *
     * @param <T>
     * @return
     */
    public static <T> FeginResponse<T> createByError() {
        return new FeginResponse<>(ResponseCode.INVALID_PARAMETER.getCode(), ResponseCode.INVALID_PARAMETER.getMsg(), false);
    }

    public static <T> FeginResponse<T> createByErrorMessage(String errorMessgae) {
        return new FeginResponse<>(ResponseCode.INVALID_PARAMETER.getCode(), errorMessgae, false);
    }

    public static <T> FeginResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new FeginResponse<>(errorCode, errorMessage, false);
    }


}
