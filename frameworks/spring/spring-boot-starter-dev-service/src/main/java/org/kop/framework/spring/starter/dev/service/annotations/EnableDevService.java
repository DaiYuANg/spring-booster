package org.kop.framework.spring.starter.dev.service.annotations;

import org.kop.framework.spring.starter.dev.service.config.DevServiceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DevServiceAutoConfiguration.class)
public @interface EnableDevService {
}
