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
public enum DeviceTypeEnum {

    //
    UN_KNOW("0", "未知"),
    ANDROID("1", "安卓"),
    IOS("2","ios"),
    PC("3", "pc端"),
    WX_H5("4", "h5页面"),
    WX_APP("5", "微信小程序"),
    ;
    String code;

    String desc;

    DeviceTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static Map<String, DeviceTypeEnum> statusMap = ImmutableMap.<String, DeviceTypeEnum>builder()
            .put(ANDROID.getCode(), ANDROID)
            .put( UN_KNOW.getCode(), UN_KNOW)
            .put(IOS.getCode(), IOS)
            .put(PC.getCode(), PC)
            .put(WX_H5.getCode(), WX_H5)
            .put( WX_APP.getCode(), WX_APP)
            .build();
    public static DeviceTypeEnum get(String code) {
        return statusMap.get(code);
    }

    public static boolean container(String code) {
        return statusMap.containsKey(code);
    }

}
