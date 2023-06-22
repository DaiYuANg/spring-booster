package org.kop.framework.spring.boot.starter.groundwork.log.annotation;

import org.kop.framework.spring.boot.starter.groundwork.log.configuration.LogAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({LogAutoConfiguration.class})
@Documented
public @interface EnableGroundworkLog {
}
