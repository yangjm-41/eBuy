package com.qy.base.exception;


import com.qy.base.comm.ResponseCode;
import lombok.Data;

/**
 * @Author: Lautumn
 * @Describe: 参数校验异常
 * @Date: Create in 上午11:26 2018/11/18
 */
@Data
public class ParamException extends RuntimeException {

    private Integer code;

    private String detailMsg;

    private Object data;

    public ParamException() {
        super("无效参数");
        this.code = ResponseCode.INVALID_PARAMETER.getCode();
        this.detailMsg = ResponseCode.INVALID_PARAMETER.getMsg();
    }


    public ParamException(String message) {
        this(message, ResponseCode.INVALID_PARAMETER.getCode());
    }

    public ParamException(String message, Integer code) {
        this(message, code, "");
    }

    public ParamException(String message, Integer code, String detailMessage) {
        this(message, code, detailMessage, null);
    }

    public ParamException(String message, Integer code, String detailMessage, Object data) {
        super(message);
        this.detailMsg = detailMessage;
        this.code = code;
        this.data = data;
    }


}
