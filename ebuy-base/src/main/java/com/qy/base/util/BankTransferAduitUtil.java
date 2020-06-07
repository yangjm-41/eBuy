package com.qy.base.util;

import com.google.common.collect.ImmutableMap;
import com.qy.base.local.LocalUtils;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 银行转账审核状态工具类
 * @author ZhengYuPeng
 * @date 2020/1/6 14:29
 */
@Getter
public enum  BankTransferAduitUtil {
    //
    NO_ADUIT(100, "转账凭证未审核", "bank.aduit.no_aduit"),
    ADUIT_ING(101, "转账凭证审核中", "bank.aduit.aduit_ing"),
    ADUIT_PASS(102, "转账凭证审核通过，改为待发货", "bank.aduit.aduit_pass"),
    ADUIT_NOPASS(103, "转账凭证审核不通过，重新上传", "bank.aduit.aduit_nopass"),
    ADUIT_CANCEL(104, "转账凭证审核拒绝，取消订单", "bank.aduit.aduit_cancel"),
    ;

    int code;
    String msg;
    String localKey;

    BankTransferAduitUtil(int code, String msg, String localKey) {
        this.code = code;
        this.msg = msg;
        this.localKey = localKey;
    }

    public String getMsg() {
        String value = LocalUtils.get(this.getLocalKey());
        if (StringUtils.isNotBlank(value)) {
            return value;
        }
        return msg;
    }

    private static Map<Integer, BankTransferAduitUtil> statusMap = ImmutableMap.<Integer, BankTransferAduitUtil>builder()
            .put(NO_ADUIT.getCode(),NO_ADUIT)
            .put(ADUIT_ING.getCode(), ADUIT_ING)
            .put(ADUIT_PASS.getCode(), ADUIT_PASS)
            .put(ADUIT_NOPASS.getCode(), ADUIT_NOPASS)
            .put(ADUIT_CANCEL.getCode(), ADUIT_CANCEL)
            .build();

    public static BankTransferAduitUtil get(int code) {
        return statusMap.get(code);
    }

}
