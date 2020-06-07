package com.qy.base.config;

import com.google.common.base.Splitter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.qy.base.util.CheckUtil.check;

/**
 * @Author: ebuy
 * @Describe: 第三方api配置环境
 * @Date: Create in 3:02 PM 2019/12/9
 */
@Configuration
@Slf4j
public class ThirdApiConfiguration {

    @Value("${spring.profiles.active:dev}")
    public String active;

    private static String activeEnv = "";

    private static String realActiveEnv = "";

    @PostConstruct
    public void init() {
        check(StringUtils.isNotBlank(active), "spring.profiles.active环境不明确");
        List<String> activeList = Splitter.on(",").splitToList(active);
        if (CollectionUtils.isEmpty(activeList)) {
            log.warn("第三方api启动服务，无法获取spring.profiles.active参数");
            activeEnv = active;
            return;
        }
        String env = activeList.get(0);
        realActiveEnv = env;
        if (env.equals("prob")) {
            env = "pro";
        }
        log.info("启动环境：【{}】", env);
        activeEnv = env;
    }

    public static String getActiveEnv() {
        return activeEnv;
    }

    public static String getRealActiveEnv(){
        return realActiveEnv;
    }
}
