/* (C)2024*/
package org.spring.boost.authentication.annotation;

import jakarta.servlet.Filter;
import java.lang.annotation.*;
import org.springframework.stereotype.Component;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface AuthenticationAfterFilter {

    Class<? extends Filter> value();
}
