package com.qy.base.util;

import com.google.common.collect.ImmutableMap;
import com.qy.base.exception.ParamException;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: ebuy
 * @Describe:
 * @Date: Create in 16:20 2019/7/12
 */
public class MobileUtil {


    /**
     * 支持的区号
     */
    public static final Map<String, String> supportRegionMap = ImmutableMap.<String, String>builder()
            .put("cn", "+86")
            .build();
    /**
     * 支持的区号
     */
    public static final Map<String, String> supportLanguageMap = ImmutableMap.<String, String>builder()
            .put("zh-cn", "+86")
            .build();

    /**
     * 手机号验证
     *
     * @return 验证通过返回true
     */
    public static boolean isMobile(final String mobile) {
        if (StringUtils.isBlank(mobile)) {
            throw new ParamException("手机号不能为空");
        }
        Pattern p = Pattern.compile("^[1][3,4,5,7,8,6,9][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    /**
     * 添加区号
     *
     * @return
     */
    public static String addRegion(String mobile, String region) {
        if (StringUtils.isBlank(region)) {
            throw new ParamException("地区不能为空");
        }
        String supportRegion = supportRegionMap.get(region.toLowerCase());
        String supportLanguage = supportLanguageMap.get(region.toLowerCase());

        if (supportRegion != null) {
            return supportRegion + mobile;
        } else if (supportLanguage != null) {
            return supportLanguage + mobile;
        } else {
            throw new ParamException("该区号的手机不支持");
        }

    }

    /**
     * 去除区号
     *
     * @return
     */
    public static String removeRegion(String mobile, String region) {
        if (StringUtils.isBlank(region)) {
            throw new ParamException("地区不能为空");
        }
        String supportRegion = supportRegionMap.get(region.toLowerCase());
        String supportLanguage = supportRegionMap.get(region.toLowerCase());
        if (supportRegion != null) {
            return mobile.replace(supportRegion, "");
        } else if (supportLanguage != null) {
            return mobile.replace(supportLanguage, "");
        } else {
            throw new ParamException("该区号的手机不支持");
        }
    }



}
