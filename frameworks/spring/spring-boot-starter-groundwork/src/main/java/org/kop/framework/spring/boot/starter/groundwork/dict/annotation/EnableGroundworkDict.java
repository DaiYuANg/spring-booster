package org.kop.framework.spring.boot.starter.groundwork.dict.annotation;

import org.kop.framework.spring.boot.starter.groundwork.dict.configuration.DictAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DictAutoConfiguration.class})
@Documented
@EnableCaching
public @interface EnableGroundworkDict {
}
