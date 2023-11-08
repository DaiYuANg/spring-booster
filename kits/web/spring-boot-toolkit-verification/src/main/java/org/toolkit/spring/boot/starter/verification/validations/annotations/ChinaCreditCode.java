package org.toolkit.spring.boot.starter.verification.validations.annotations;

import jakarta.validation.Constraint;
import java.lang.annotation.*;

import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import org.toolkit.spring.boot.starter.verification.validations.validators.ChinaCreditCodeValidator;

@Documented
@Constraint(validatedBy = ChinaCreditCodeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
public @interface ChinaCreditCode {
    String message() default "{jakarta.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
