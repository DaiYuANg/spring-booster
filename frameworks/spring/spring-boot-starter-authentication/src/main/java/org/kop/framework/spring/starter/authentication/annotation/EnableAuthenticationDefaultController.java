package org.kop.framework.spring.starter.authentication.annotation;

import org.kop.framework.spring.starter.authentication.configurations.DefaultControllerImplementConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DefaultControllerImplementConfiguration.class})
@Documented
public @interface EnableAuthenticationDefaultController {
}
