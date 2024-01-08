/* (C)2024*/
package org.spring.boost.office.annotation;

import org.spring.boost.office.constant.Workbook;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExcelObject {
    Workbook expectWorkbook() default Workbook.HSSF_WORK_BOOK;
}
