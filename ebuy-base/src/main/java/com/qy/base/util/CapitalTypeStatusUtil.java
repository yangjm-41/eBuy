package com.qy.base.util;

import com.google.common.collect.ImmutableMap;
import lombok.Getter;

import java.util.Map;


/**
 * @Author: Lautumn
 * @Describe: 钱包详情记录类型工具类
 * @Date: Create in 16:09 2019/6/24
 */
@Getter
public enum CapitalTypeStatusUtil {
    YUE(1, "余额"),
    HUOKUAN(2, "货款"),
    ;

    String msg;
    int code;

    CapitalTypeStatusUtil(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private static Map<Integer, CapitalTypeStatusUtil> statusMap = ImmutableMap.<Integer, CapitalTypeStatusUtil>builder()
            .put(YUE.getCode(), YUE)
            .put(HUOKUAN.getCode(), HUOKUAN)
            .build();

    public static CapitalTypeStatusUtil get(int code) {
        return statusMap.get(code);
    }

}
