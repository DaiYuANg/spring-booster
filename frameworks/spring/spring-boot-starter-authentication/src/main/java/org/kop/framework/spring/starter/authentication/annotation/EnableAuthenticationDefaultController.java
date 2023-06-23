package org.kop.framework.spring.starter.authentication.annotation;

import org.kop.framework.spring.starter.authentication.configurations.AuthenticationDefaultControllerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({AuthenticationDefaultControllerConfiguration.class})
@Documented
public @interface EnableAuthenticationDefaultController {
}
