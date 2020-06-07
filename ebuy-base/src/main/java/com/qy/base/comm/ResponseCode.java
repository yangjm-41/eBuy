package com.qy.base.comm;

import com.qy.base.local.LocalUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ebuy
 * @Describe: 统一响应码
 * @Date: Create in 10:47 2019/5/5
 */
@Slf4j
@Getter
public enum ResponseCode {

    //
    SUCCESS(0, "成功", "response.code.success"),


    // 操作相关
    INVALID_PARAMETER(-1, "无效参数", "response.code.invalid_parameter"),
    ;

    int code;
    String msg;
    String localKey;

    ResponseCode(int code, String msg, String localKey) {
        this.code = code;
        this.msg = msg;
        this.localKey = localKey;
    }

    /**
     * 国际化返回
     * @return
     */
    public String getMsg() {
        try {
            String value = LocalUtils.get(this.getLocalKey());
            if (StringUtils.isNotBlank(value) && !this.getLocalKey().equals(value)) {
                return value;
            }
        } catch (Exception e) {
            log.warn(this.getLocalKey() + "未配置国际化");
        }
        return msg;
    }
}
