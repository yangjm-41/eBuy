package com.qy.base.util;


import com.qy.base.comm.ResponseCode;
import com.qy.base.exception.ParamException;
import com.qy.base.local.LocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Lautumn
 * @Describe: 参数校验工具类
 * @Date: Create in 下午8:25 2018/12/11
 */
@Slf4j
public class CheckUtil {

    /**
     * 检查表达式
     *
     * @param condition 返回 false 进入失败
     * @param message   返回的提示信息
     */
    public static void check(boolean condition, String message) {
        if (!condition) {
            fail(message);
        }
    }

    /**
     * 检查表达式
     *
     * @param condition 返回 false 进入失败
     * @param message   返回的提示信息
     * @param code      错误编码
     */
    public static void check(boolean condition, String message, Integer code) {
        if (!condition) {
            fail(message, code, null);
        }
    }


    /**
     * 检查表达式
     *
     * @param condition 返回 false 进入失败
     * @param message   返回的提示信息
     * @param code      错误编码
     * @param param     返回给前端的数据
     */
    public static void check(boolean condition, String message, Integer code, Object param) {
        if (!condition) {
            fail(message, code, param);
        }
    }

    /**
     * 检查表达式
     *
     * @param condition     返回 false 进入失败
     * @param message       返回的提示信息
     * @param code          错误编码
     * @param detailMessage 错误详细数据
     * @param param         返回给前端的数据
     */
    public static void check(boolean condition, String message, Integer code, String detailMessage, Object param) {
        if (!condition) {
            fail(message, code, detailMessage, param);
        }
    }


    /**
     * 检查表达式
     *
     * @param condition     返回 false 进入失败
     * @param message       返回的提示信息
     * @param detailMessage 调试信息，
     */
    public static void check(boolean condition, String message, String detailMessage) {
        if (!condition) {
            fail(message, detailMessage);
        }
    }


    /**
     * 检查表达式，返回国际化信息
     *
     * @param condition 返回 false 进入失败
     * @param message   返回的提示信息
     * @param message
     */
    public static void check(boolean condition, ResponseCode message) {
        if (!condition) {
            fail(LocalUtils.get(message.getLocalKey()));
        }
    }


    private static void fail(String message) {
        log.info("检查错误：【{}】", message);
        throw new ParamException(message);
    }

    private static void fail(String message, String detailMessage) {
        log.info("检查错误：【{}】,【{}】", message, detailMessage);
        throw new ParamException(message, ResponseCode.INVALID_PARAMETER.getCode(), detailMessage);
    }

    private static void fail(String message, Integer code, Object param) {
        throw new ParamException(message, code, "", param);
    }

    private static void fail(String message, Integer code, String detailMessage) {
        throw new ParamException(message, code, detailMessage);
    }


    private static void fail(String message, Integer code, String detailMessage, Object param) {
        throw new ParamException(message, code, detailMessage, param);
    }

    public static void notEmpty(String parentId, String message) {
        check(StringUtils.isNotEmpty(parentId), message);
    }

    public static void notNull(Object object, String message) {
        check(object != null, message);
    }
}
