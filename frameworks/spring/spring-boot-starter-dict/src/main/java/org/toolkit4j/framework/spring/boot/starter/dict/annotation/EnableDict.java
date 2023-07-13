package org.toolkit4j.framework.spring.boot.starter.dict.annotation;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.toolkit4j.framework.spring.boot.starter.dict.configuration.DictAutoConfiguration;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DictAutoConfiguration.class})
@Documented
@EnableCaching
public @interface EnableDict {
}
