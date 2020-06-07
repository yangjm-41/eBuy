package com.qy.base.util;

import com.google.common.collect.ImmutableMap;
import com.qy.base.local.LocalUtils;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;


/**
 * @Author: Lautumn
 * @Describe: 审核状态工具类
 * @Date: Create in 16:09 2019/6/24
 */
@Getter
public enum AuditTypeStatusUtil {
    UN_AUDIT(1, "未审核","audit.status.un"),
    PASS_AUDIT(2, "已通过","audit.status.pass"),
    UN_PASS_AUDIT(3, "未通过","audit.status.un_pass"),
    WAIT_AUDIT(4, "待提交","audit.status.wait");
    String msg;
    int code;
    String localKey;


    AuditTypeStatusUtil(int code, String msg,String localKey) {
        this.msg = msg;
        this.code = code;
        this.localKey = localKey;

    }

    private static Map<Integer, AuditTypeStatusUtil> statusMap = ImmutableMap.of(
            UN_AUDIT.getCode(), UN_AUDIT,
            PASS_AUDIT.getCode(), PASS_AUDIT,
            UN_PASS_AUDIT.getCode(), UN_PASS_AUDIT,
            WAIT_AUDIT.getCode(), WAIT_AUDIT
    );

    public String getMsg() {
        String value = LocalUtils.get(this.getLocalKey());
        if (StringUtils.isNotBlank(value)) {
            return value;
        }
        return msg;
    }

    public static AuditTypeStatusUtil get(int code) {
        return statusMap.get(code);
    }

    public static boolean container(int code) {
        return statusMap.containsKey(code);
    }


}
