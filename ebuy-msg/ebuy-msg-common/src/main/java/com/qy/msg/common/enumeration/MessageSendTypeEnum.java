package com.qy.msg.common.enumeration;

/**
 * @author Tang
 * @description: todo
 * @time 2019/10/22 4:22 下午
 */
public enum  MessageSendTypeEnum {

    DEFAULT("local"),


    /**
     * rabbitmq发送类型
     */
    RABBIT_MQ("rabbitmq"),


    /**
     * 本地发送类型
     */
    LOCAL("local"),

    /**
     * 网易云信发送类型
     */
    WANG_YI_YUN_XIN("wangyiyunxin");

    private String type;

    MessageSendTypeEnum(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
