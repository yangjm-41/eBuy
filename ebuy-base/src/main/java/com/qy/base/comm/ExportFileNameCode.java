package com.qy.base.comm;

import com.qy.base.local.LocalUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Lautumn
 * @Describe: 导出文件国际化名称
 * @Date: Create in 10:47 2019/5/5
 */
@Slf4j
@Getter
public enum ExportFileNameCode {


    //
    EXPORT_GOODS_INFO(0, "商品信息", "export.goods.info"),
    EXPORT_BRAND_INFO(0, "品牌信息", "export.brand.info"),;

    // 登陆相关

    int code;
    String msg;
    String localKey;

    ExportFileNameCode(int code, String msg, String localKey) {
        this.code = code;
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
