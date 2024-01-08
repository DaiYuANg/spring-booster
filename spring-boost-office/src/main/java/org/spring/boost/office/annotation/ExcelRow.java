/* (C)2024*/
package org.spring.boost.office.annotation;

import java.lang.annotation.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.usermodel.Borders;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ExcelRow {

    String title();

    int order() default 0; // 排序顺序，可以按照该值进行排序

    boolean required() default false; // 是否必填字段，默认为非必填

    boolean wrapped() default true;

    boolean bold() default false;

    boolean italic() default false;

    String fontName() default "";

    short fontHeight() default 10;

    HorizontalAlignment align() default HorizontalAlignment.CENTER;

    VerticalAlignment verticalAlign() default VerticalAlignment.CENTER;

    Borders borderBottom() default Borders.NONE;

    Borders borderTop() default Borders.NONE;

    Borders borderLeft() default Borders.NONE;

    Borders borderRight() default Borders.NONE;

    Borders borderAll() default Borders.NONE;

    IndexedColors fillForegroundColor() default IndexedColors.WHITE;

    FillPatternType fillPattern() default FillPatternType.NO_FILL;

    short dataFormat() default 1;

    boolean hidden() default false;

    boolean locked() default false;

    int indentation() default 0;

    boolean shrinkToFit() default false;

    int rotation() default 0;

    boolean showInPane() default false;

    boolean autoSizeColumn() default false;

    boolean mergeCell() default false;

    boolean richText() default false;
}
