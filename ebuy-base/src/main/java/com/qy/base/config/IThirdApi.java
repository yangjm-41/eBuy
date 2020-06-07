package com.qy.base.config;


import com.qy.base.exception.ParamException;

/**
 * @Author: ebuy
 * @Describe: 第三方api工具类
 * @Date: Create in 16:09 2019/9/5
 */
public interface IThirdApi {

    /**
     * 测试环境domain
     *
     * @return
     */
    String devBaseDomain();

    /**
     * 生成环境domain
     *
     * @return
     */
    String proBaseDomain();

    /**
     * 根据环境不同来拼接url的domain
     *
     * @param url
     * @param param
     * @return
     */
    default String genUrl(String url, Object... param) {
        String activeEnv = ThirdApiConfiguration.getActiveEnv();
        StringBuilder builder = new StringBuilder();
        if (activeEnv.equals("local")) {
            builder.append(devBaseDomain());
        } else if (activeEnv.equals("dev")) {
            builder.append(devBaseDomain());
        } else if (activeEnv.equals("pro")) {
            builder.append(proBaseDomain());
        } else {
            new ParamException("环境配置错误：" + activeEnv);
        }

        builder.append(url);
        if (param.length > 0) {
            return addParam(builder.toString(), param);
        }
        return builder.toString();

    }

    /**
     * 传入domain来拼接url
     *
     * @param domain
     * @param url
     * @param param
     * @return
     */
    default String genUrl(String domain, String url, Object... param) {
        StringBuilder builder = new StringBuilder();
        builder.append(domain).append(url);
        if (param.length > 0) {
            return addParam(builder.toString(), param);
        }
        return builder.toString();

    }


    /**
     * 添加参数到url标记的{}中
     * 如
     * /paymentOrders/{source}/{orderId}
     *
     * @param url
     * @param params
     * @return
     */
    default String addParam(String url, Object... params) {
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params == null || params.length == 0) {
            return urlBuilder.toString();
        }
        for (Object param : params) {
            int leftIndex = urlBuilder.indexOf("{");
            int rightIndex = urlBuilder.indexOf("}");
            if (leftIndex == -1 || rightIndex == -1) {
                throw new ParamException("url中的{}不匹配");
            }
            urlBuilder = urlBuilder.replace(leftIndex, rightIndex + 1, String.valueOf(param));
        }
        return urlBuilder.toString();
    }
}
