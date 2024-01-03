/* (C)2024*/
package org.toolkit.spring.boot.authentication.annotation;

import jakarta.servlet.Filter;
import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface AuthenticationBeforeFilter {

	Class<? extends Filter> value();
}
