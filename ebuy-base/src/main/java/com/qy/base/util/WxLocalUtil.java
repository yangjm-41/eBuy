package com.qy.base.util;

import com.qy.base.local.LocalUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ZhengYupeng
 * @Describe: app接口国际化工具
 */
@Slf4j
@Getter
public enum WxLocalUtil {
    Level1("一级", "wxlocalutil.normal.Level1"),
    Level2("二级", "wxlocalutil.normal.Level2"),
    Level3("三级", "wxlocalutil.normal.Level3"),
    ;
    String msg;
    String localKey;

    WxLocalUtil(String msg, String localKey) {
        this.msg = msg;
        this.localKey = localKey;
    }

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
