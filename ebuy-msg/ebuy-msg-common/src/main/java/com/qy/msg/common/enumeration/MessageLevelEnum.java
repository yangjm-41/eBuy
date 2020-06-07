package com.qy.msg.common.enumeration;

/**
 * @Author Tang
 * @Description 消息级别可控制是否强制推送
 * 数字越大级别越高
 * @Date 15:08 2019/8/14
 * @Param
 * @return
 **/
public enum MessageLevelEnum {

    /**
     * 消息级别1
     **/
    LEVEL_ONE(1, "1级"),

    /**
     * 消息级别2
     **/
    LEVEL_TOW(2, "2级"),

    /**
     * 消息级别3
     **/
    LEVEL_THREE(3, "3级");

    private String msg;

    private int code;

    MessageLevelEnum(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public static String getMsg(Integer code) {
        MessageLevelEnum[] values = values();
        for (MessageLevelEnum businessModeEnum : values) {
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
