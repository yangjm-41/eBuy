package com.qy.base.util;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.Map;

/**
 * @Author: Lautumn
 * @Describe:
 * @Date: Create in 14:40 2019/9/17
 */
@Getter
public enum UserAgentEnum {
    //
    APP(1, "移动端"),
    PC(2, "pc端"),
    WX_H5(3, "h5页面"),
    WX_APP(4, "微信小程序"),
    WX_PUBLISH(5, "微信公众号"),
    ;
    int code;

    String desc;

    UserAgentEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<Integer, UserAgentEnum> statusMap = ImmutableMap.of(
            APP.getCode(), APP,
            PC.getCode(), PC,
            WX_H5.getCode(), WX_H5,
            WX_APP.getCode(), WX_APP,
            WX_PUBLISH.getCode(), WX_PUBLISH
    );

    public static UserAgentEnum get(int code) {
        return statusMap.get(code);
    }

    public static boolean container(int code) {
        return statusMap.containsKey(code);
    }

}
