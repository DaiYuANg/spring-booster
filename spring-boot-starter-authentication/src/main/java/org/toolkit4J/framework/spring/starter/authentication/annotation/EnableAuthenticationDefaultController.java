package org.toolkit4J.framework.spring.starter.authentication.annotation;

import java.lang.annotation.*;
import org.springframework.context.annotation.Import;
import org.toolkit4J.framework.spring.starter.authentication.configurations.DefaultControllerImplementConfiguration;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DefaultControllerImplementConfiguration.class})
@Documented
public @interface EnableAuthenticationDefaultController {}
