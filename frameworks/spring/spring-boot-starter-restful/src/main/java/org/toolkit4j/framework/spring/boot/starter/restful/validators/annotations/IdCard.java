package org.toolkit4j.framework.spring.boot.starter.restful.validators.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.toolkit4j.framework.spring.boot.starter.restful.validators.IdCardValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdCardValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdCard {
    String message() default "Invalid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
