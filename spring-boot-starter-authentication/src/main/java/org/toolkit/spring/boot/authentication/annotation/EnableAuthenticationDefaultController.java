package org.toolkit.spring.boot.authentication.annotation;

import java.lang.annotation.*;
import org.springframework.context.annotation.Import;
import org.toolkit.spring.boot.authentication.configurations.DefaultControllerImplementConfiguration;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DefaultControllerImplementConfiguration.class})
@Documented
public @interface EnableAuthenticationDefaultController {}
