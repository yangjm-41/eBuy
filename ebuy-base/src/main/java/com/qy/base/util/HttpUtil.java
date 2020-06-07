package com.qy.base.util;

import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;


public class HttpUtil {

    private static final String platformHeard = "X-Litemall-IdentiFication";

    public static String getPlatformheard(HttpServletRequest request) {
        return request.getHeader(platformHeard);
    }

    public static String getPlatformHeard() {
        return platformHeard;
    }


    /**
     * 判断是否是json请求
     *
     * @param request
     * @return
     */
    public static boolean isJson(HttpServletRequest request) {
        if (request.getContentType() == null) {
            return false;
        }
        return request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE) ||
                request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE);
    }
}
