package com.ruoyi.project.tool.codegenerator.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* 用法：给每个字段都标注@FieldMapping，
* 如果有的字段不需要在添加框显示，把isNeed指定为false
* */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMapping {
    String value() default "";

    boolean isNeed() default true;
}
