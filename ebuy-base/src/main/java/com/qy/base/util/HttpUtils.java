package com.qy.base.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Component
public class HttpUtils {


    public static final String PLATFORMHEARD = "X-Litemall-IdentiFication";

    /**
     * 设备类型
     * {@link UserAgentEnum}
     */
    public static final String DEVICE_TYPE = "deviceType";

    public static final String PLATFORMHEARD2 = "platform";

    public static final String[] deviceArray = new String[]{"android", "iphone os", "windows phone", "micromessenger", "iphone", "ipad", "ipod"};


    public static final String HEAD_HTTP_PATTERN = "http://.+|HTTP://.+";

    private static Pattern httpPattern = Pattern.compile(HEAD_HTTP_PATTERN);

    public static Boolean isHttpPrefix(String url) {
        Matcher matcher = httpPattern.matcher(url);
        return matcher.matches() ? true : false;
    }

    /**
     * 获取平台表示请求头或者参数中获取
     *
     * @return
     */
    public static String getPlatform(HttpServletRequest request) {
        return getPlatformStr(request);
    }

    /**
     * 获取设备类型请求头或者参数中获取
     *
     * @return
     */
    public static String getDeviceType(HttpServletRequest request) {
        String platform = request.getHeader(DEVICE_TYPE);
        if (StringUtils.isNotBlank(platform)) {
            return platform;
        }
        platform = request.getParameter(DEVICE_TYPE);
        if (StringUtils.isNotBlank(platform)) {
            return platform;
        }
        return "";
    }

    private static String getPlatformStr(HttpServletRequest request) {
        String platform = request.getHeader(PLATFORMHEARD);
        if (StringUtils.isNotBlank(platform)) {
            return platform;
        }
        platform = request.getHeader(PLATFORMHEARD2);
        if (StringUtils.isNotBlank(platform)) {
            return platform;
        }
        platform = request.getParameter(PLATFORMHEARD);
        if (StringUtils.isNotBlank(platform)) {
            return platform;
        }
        platform = request.getParameter(PLATFORMHEARD2);
        if (StringUtils.isNotBlank(platform)) {
            return platform;
        }

        return "";
    }


    public static String getToken(HttpServletRequest request) {
        String authorization = request.getHeader("X-Litemall-Admin-Token");
        if (StringUtils.isNotBlank(authorization)) {
            return authorization;
        }
        authorization = request.getHeader("X-Litemall-Token");
        if (StringUtils.isNotBlank(authorization)) {
            return authorization;
        }

        authorization = request.getHeader("token");
        if (StringUtils.isNotBlank(authorization)) {
            return authorization;
        }

        return request.getParameter("token");
    }

    public static String getRequestURL(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        return requestURL.toString();
    }

    public static Map<String, String[]> getParameterMap(HttpServletRequest request) {
        return request.getParameterMap();
    }

    public static String getIpAddr(HttpServletRequest request) {
        return IpUtil.getIpAddr(request);
    }

    /**
     * 是否前端
     *
     * @param request
     * @return
     */
    public static boolean isMobile(HttpServletRequest request) {
        if (request == null) {
            return false;
        }

        String requestHeader = request.getHeader("user-agent");
        /**
         * android : 所有android设备
         * mac os : iphone ipad
         * windows phone:Nokia等windows系统的手机
         */
        if (requestHeader == null) {
            return false;
        }
        requestHeader = requestHeader.toLowerCase();

        log.info("请求设备:" + requestHeader);
        for (int i = 0; i < deviceArray.length; i++) {
            if (requestHeader.indexOf(deviceArray[i]) != -1) {
                return true;
            }
        }
        return false;

    }
}
