/* (C)2023*/
package org.toolkit.spring.boot.web.annotation;

import java.lang.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidRestController {}