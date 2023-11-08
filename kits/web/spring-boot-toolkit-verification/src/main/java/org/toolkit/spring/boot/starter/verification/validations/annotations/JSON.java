package org.toolkit.spring.boot.starter.verification.validations.annotations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;

import jakarta.validation.Payload;
import org.toolkit.spring.boot.starter.verification.validations.validators.JSONValidator;

@Documented
@Constraint(validatedBy = JSONValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSON {
    String message() default "{jakarta.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
