package org.toolkit.spring.boot.verification.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import org.toolkit.spring.boot.verification.validation.validator.JSONValidator;

@Documented
@Constraint(validatedBy = JSONValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSON {
	String message() default "{jakarta.validation.constraints.NotBlank.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
