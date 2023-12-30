/* (C)2023*/
package org.toolkit.spring.boot.web.annotation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping
public @interface ValidationController {}
