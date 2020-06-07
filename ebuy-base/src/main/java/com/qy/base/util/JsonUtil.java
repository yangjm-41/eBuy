package com.qy.base.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Lautumn
 * @Describe:
 * @Date: Create in 16:53 2020/6/2
 */

public class JsonUtil {

    /**
     * 解析json
     *
     * @param extend
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T converObject(String extend, Class<T> clazz) {
        if (StringUtils.isBlank(extend)) {
            return JSON.parseObject("{}", clazz);
        }
        return JSON.parseObject(extend, clazz);
    }

}
