package org.kop.framework.spring.boot.starter.groundwork.tag.annotation;

import org.kop.framework.spring.boot.starter.groundwork.tag.configuration.TagAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({TagAutoConfiguration.class})
@Documented
public @interface EnableGroundworkTag {
}
