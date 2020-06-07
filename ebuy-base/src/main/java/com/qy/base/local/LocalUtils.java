package com.qy.base.local;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * 国际化工具类
 */
@Slf4j
@Component
public class LocalUtils {


    private static MessageSource messageSource;

    public LocalUtils(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * 获取单个国际化翻译值
     */
    public static String get(String msgKey) {
        try {
            Locale local = LocaleContextHolder.getLocale();
            if (messageSource instanceof DelegatingMessageSource) {
                log.debug("找不到国际化资源文件请将,base下static.i18n.messages复制到当前项目resource下,并指定spring.messages.basename:static/i18n/messages");
                return msgKey;
            }
            try {
                String message = messageSource.getMessage(msgKey, null, local);
                 return  message;
            }catch (NoSuchMessageException e){
            log.debug(msgKey+"未配置国际化");
            return msgKey;
        }

        } catch (Exception e) {
            log.warn(msgKey+"未配置国际化");
            return msgKey;
        }
    }
}