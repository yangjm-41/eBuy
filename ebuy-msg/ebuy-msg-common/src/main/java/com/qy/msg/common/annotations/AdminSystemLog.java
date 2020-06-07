package com.qy.msg.common.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  * @Describe: 系统日志，标记在controller的方法上
 * @Date: Create in 19:21 2019/4/24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AdminSystemLog {

    /**
     * 描述
     *
     * @return
     */
    String desc() default "";

    /**
     * 方法名称
     *
     * @return
     */
    String message() default "";


}

