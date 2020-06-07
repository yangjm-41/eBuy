package com.qy.base.gener.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ebuy
 * @Describe: 状态和文本映射
 * @Date: Create in 19:21 2019/4/24
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Dict {

    /**
     * example  {"未使用","已使用","已完成"}
     * @return
     */
    String[] label() default {};

    /**
     * example      {"0","1","2"}
     * @return
     */
    String[] value() default {};


}

