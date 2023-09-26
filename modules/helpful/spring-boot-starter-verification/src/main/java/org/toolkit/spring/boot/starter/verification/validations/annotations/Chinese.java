package org.toolkit.spring.boot.starter.verification.validations.annotations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;
import org.toolkit.spring.boot.starter.verification.validations.validators.ChineseValidator;

@Documented
@Constraint(validatedBy = ChineseValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Chinese {}
