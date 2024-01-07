/* (C)2023*/
package org.spring.boost.web.core.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Interceptor {
    String[] value() default "";

    String[] excludePath() default "";

    int order() default 0;
}
