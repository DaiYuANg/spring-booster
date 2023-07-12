package org.toolkit4j.framework.spring.starter.authentication.annotation;

import org.springframework.context.annotation.Import;
import org.toolkit4j.framework.spring.starter.authentication.configurations.DefaultControllerImplementConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DefaultControllerImplementConfiguration.class})
@Documented
public @interface EnableAuthenticationDefaultController {
}
