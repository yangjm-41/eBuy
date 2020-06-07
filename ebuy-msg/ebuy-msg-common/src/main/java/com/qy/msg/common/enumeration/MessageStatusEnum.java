package com.qy.msg.common.enumeration;

/**
 * @Author Tang
 * @Description
 * @Date 15:08 2019/8/14
 * @Param
 * @return
 **/
public enum MessageStatusEnum {

    /**
     * 消息状态未读
     **/
    UNREAD(0, "未读"),

    /**
     * 消息状态已读
     **/
    READY(1, "已读"),

    /**
     * 消息状态撤回
     **/
    REVOCATION(3, "撤回");

    private String msg;

    private int code;

    MessageStatusEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsg(Integer code) {
        MessageStatusEnum[] values = values();
        for (MessageStatusEnum businessModeEnum : values) {
            if (businessModeEnum.getCode() == code) {
                return businessModeEnum.getMsg();
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
