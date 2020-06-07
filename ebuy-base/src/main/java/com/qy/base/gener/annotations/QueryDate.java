package com.qy.base.gener.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ebuy
 * @Describe: 是否需要查询日期，添加在类上
 * @Date: Create in 19:21 2019/4/24
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface QueryDate {

    // 前端显示开始时间查询
    boolean beginDate() default false;

    // 前端显示结束时间查询
    boolean endDate() default false;

    /**
     * 是否显示新增按钮，默认是
     * @return
     */
    boolean haveAdd() default true;

    /**
     * 是否显示编辑按钮，默认是
     * @return
     */
    boolean haveEdit() default true;

    /**
     * 是否显示删除按钮
     * @return
     */
    boolean haveDel() default true;

}
