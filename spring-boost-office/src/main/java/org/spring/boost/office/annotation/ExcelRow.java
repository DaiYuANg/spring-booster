/* (C)2024*/
package org.spring.boost.office.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ExcelRow {

    String title();

    int order() default 0; // 排序顺序，可以按照该值进行排序

    boolean required() default false; // 是否必填字段，默认为非必填
}
