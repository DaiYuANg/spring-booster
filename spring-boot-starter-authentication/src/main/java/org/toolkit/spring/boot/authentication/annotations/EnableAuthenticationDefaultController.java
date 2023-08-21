package org.toolkit.spring.boot.authentication.annotations;

import org.springframework.context.annotation.Import;
import org.toolkit.spring.boot.authentication.configurations.DefaultControllerImplementConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DefaultControllerImplementConfiguration.class})
@Documented
public @interface EnableAuthenticationDefaultController {}
