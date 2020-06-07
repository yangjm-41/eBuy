package com.qy.msg.common.enumeration;

import lombok.Getter;


/**
 * @Author Tang
 * @Description 消息类型
 * @Date 15:11 2019/8/14
 * @Param
 * @return
 **/
@Getter
public enum MessageSkipTypeEnum {

    NOT_SKIP(0, "无跳转"),
    SKIP_URL(101, "跳转url连接"),
    GOODS(102, "商品跳转"),
    SCENIC(103, "景点跳转"),
    TOPIC(104, "热门专区跳转"),
    DAILY_NEW(105, "每日最新跳转"),
    HONGDONG(106, "活动跳转"),

    ;

    /**
     * 信息内容
     */
    private String msg;

    private Integer type;

    MessageSkipTypeEnum(int type, String msg) {
        this.msg = msg;
        this.type = type;
    }

}
