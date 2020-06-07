package com.qy.base.gener.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: ebuy
 * @Describe: 字段属性，添加在字段上
 * <p>
 * String   -> varcahr  类型
 * @ColAttr(value = "问卷模板id", columnDefinition = "varchar(60)  not null default '' comment '问卷模板id'")
 * <p>
 * Boolean  -> tinyint  类型
 * @ColAttr(value = "问卷模板id", columnDefinition = "tinyint  not null default '0' comment '问卷模板id'")
 * <p>
 * Integer  -> int      类型
 * @ColAttr(value = "问卷模板id", columnDefinition = "int  not null default '0' comment '问卷模板id'")
 * <p>
 * <p>
 * Integer  -> tinyint      类型
 * @ColAttr(value = "问卷模板id", columnDefinition = "tinyint  not null default '0' comment '问卷模板id'")
 * <p>
 * Date     -> datetime 类型
 * @ColAttr(value = "问卷模板id", columnDefinition = "datetime  comment '问卷模板id'")
 * <p>
 * String   -> text     类型
 * @ColAttr(value = "问卷模板id", columnDefinition = "text comment '问卷模板id'")
 * @Date: Create in 19:21 2019/4/24
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ColAttr {
    // 默认不是查询条件，前端显示输入框查询
    boolean isQuery() default false;

    // 默认不是前端显示的列，前端显示数据列的表头
    boolean isFrontCol() default false;

    // 默认是表单项 新增和修改显示的表单
    boolean isFrom() default true;

    // 表单项默认可以为空 前端表单项校验是否为空
    boolean isNull() default true;

    // 属性描述
    String value() default "";

    // 列定义，如 columnDefinition = "varchar(63) default '' not null comment '密码'"
    String columnDefinition() default "";

    // 列名，空的话默认字段驼峰
    String columnName() default "";

}
