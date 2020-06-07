package com.qy.msg.common.enumeration;

import com.qy.base.local.LocalUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Tang
 * @Description 消息类型
 * @Date 15:11 2019/8/14
 * @Param
 * @return
 **/
public enum MessageEnum {


    /**
     * 普通消息
     **/
    COMMON_MESSAGE(10000, "message.common", 0, 1),

    /**
     * 系统消息
     **/
    SYSTEM_MESSAGE(10001, "message.common.system", 1, 1),

    /**
     * 订单信息
     **/
    ORDER_MESSAGE(10002, "message.common.order", 0, 0),

    /**
     * 售后信息
     **/
    AFTER_SALE_MESSAGE(10003, "message.common.after", 0, 0),

    /**
     * 活动信息
     **/
    ACTIVITY_MESSAGE(10004, "message.common.activity", 1, 1),

    /**
     * 申请加群审核消息
     **/
    GROUP_APPLY_AUDIT(10005, "message.common.group_apply_audit", 0, 0),

    /**
     * 邀请加入群消息
     **/
    GROUP_INVITE_GROUP(10006, "message.common.group_invite_group", 0, 0),

    /**
     * 群公告消息   展会公告
     **/
    GROUP_ANNOUNCEMENT(10007, "message.common.group_invite_group", 0, 0),
    /**
     * 群公告消息   展会公告
     **/
    EXHIBIT_MESSAGE(10008, "message.common.group_invite_group", 1, 1),

    /**
     * 聊天信息
     **/
    CHAT_INFOMATION(20001, "message.member.chat", 0, 0),

    /**
     * 系统运行时信息
     **/
    SYSTEM_RUNTIME_MESSAGE(50001, "message.system.runtime", 0, 0),

    /**
     * 系统错误信息
     **/
    SYSTEM_ERROR_MESSAGE(50002, "message.system.error", 0, 0),

    /**
     * 系统日志信息
     **/
    SYSTEM_LOG(50003, "message.system.log", 0, 0),

    /**
     * 系统通知信息
     **/
    SYSTEM_MESSAGE_LOG(50004, "message.system.notice", 0, 1),

    /**
     * 系统公告
     **/
    SYSTEM_ANNOUNCEMENT(50005, "message.common.announcement", 1, 1),
    /**
     * 点赞消息
     **/
    THUMB_UP_NEWS(50006, "message.thumbup.news", 1, 1),
    /**
     * 评论消息
     **/
    COMMENT_ON_NEWS(50007, "message.comment.news", 1, 1),
    /**
     * 课程活动快报
     **/
    ACTIVITY_EXPRESS(50008, "message.activity.express", 1, 1),

    /**
     * 用户访问快报
     **/
    ACCESS_EXPRESS(50009,"message.to.seeTable",1,1),

    /**
     * 用户访问快报
     **/
    ACCESS_EXPRESS_TO_USER(50010,"message.to.seeUser",1,1),

    /**
     * 推送app消息
     **/
    APP_MESSAGE(60001,"message.common.app",1,1),
    ;

    /**
     * 信息内容
     */
    private String msg;

    /**
     * 信息编码
     */
    private int type;

    /**
     * 是否可以通过后台手动发送该类型信息,0否，1是
     */
    private int manualSend;

    /**
     * 群发消息0否，1是
     */
    private int groupMessage;


    MessageEnum(int type, String msg) {
        this.msg = msg;
        this.type = type;
        this.manualSend = 0;
    }

    MessageEnum(int type, String msg, int manualSend) {
        this.msg = msg;
        this.type = type;
        this.manualSend = manualSend;
        this.groupMessage = 0;
    }


    MessageEnum(int type, String msg, int manualSend, int groupMessage) {
        this.msg = msg;
        this.type = type;
        this.manualSend = manualSend;
        this.groupMessage = groupMessage;

    }

    public static String getMsg(Integer code) {
        MessageEnum[] values = values();
        for (MessageEnum businessModeEnum : values) {
            if (businessModeEnum.getType() == code) {
                return businessModeEnum.getMsg();
            }
        }
        return null;
    }

    public static MessageEnum getEnum(Integer code) {
        MessageEnum[] values = values();
        for (MessageEnum messageEnum : values) {
            if (messageEnum.getType() == code) {
                return messageEnum;
            }
        }
        return null;
    }


    public static int getManualSendInt(int code) {
        MessageEnum[] values = values();
        for (MessageEnum messageEnum : values) {
            if (messageEnum.getType() == code) {
                return messageEnum.getManualSend();
            }
        }
        return 0;
    }


    public static List getManualSendList() {
        MessageEnum[] values = values();

        List<MessageEnum> collect = Arrays.stream(values).filter(e -> 1 == e.getManualSend()).collect(Collectors.toList());
        return collect;
    }


    public String getMsg() {
        return LocalUtils.get(msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getManualSend() {
        return manualSend;
    }

    public void setManualSend(int manualSend) {
        this.manualSend = manualSend;
    }
}
