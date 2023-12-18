/* (C)2023*/
package org.toolkit.spring.boot.authentication.annotation;

import java.lang.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreAuthentication {
	RequestMethod[] ignoreOnMethod() default {
		RequestMethod.PATCH,
		RequestMethod.GET,
		RequestMethod.HEAD,
		RequestMethod.DELETE,
		RequestMethod.OPTIONS,
		RequestMethod.PUT,
		RequestMethod.TRACE,
		RequestMethod.PATCH,
		RequestMethod.POST
	};
}
