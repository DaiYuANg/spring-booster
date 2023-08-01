package org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.validators.PhoneNumberValidator;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {}
