package org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.validators.JSONValidator;

@Documented
@Constraint(validatedBy = JSONValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSON {}
