package org.toolkit.spring.boot.starter.dict.annotations;

import java.lang.annotation.*;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.toolkit.spring.boot.starter.dict.configuration.DictAutoConfiguration;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({DictAutoConfiguration.class})
@Documented
@EnableCaching
public @interface EnableDict {}
