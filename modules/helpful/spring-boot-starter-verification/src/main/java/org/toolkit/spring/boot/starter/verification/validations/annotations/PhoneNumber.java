package org.toolkit.spring.boot.starter.verification.validations.annotations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;
import org.toolkit.spring.boot.starter.verification.validations.validators.PhoneNumberValidator;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {}