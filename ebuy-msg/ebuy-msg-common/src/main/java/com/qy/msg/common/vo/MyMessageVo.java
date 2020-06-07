package com.qy.msg.common.vo;

import lombok.Data;

@Data
public class MyMessageVo {


    /**
     * 消息类型
     */
    private Integer type;


    /**
     * 消息类型名称
     */
    private String typeName;


    /**
     * 消息内容
     */
    private String content;


    /**
     * 未读消息
     */
    private Integer unread;


    /**
     * 消息最后时间
     */
    private String lasedate;


}
