package org.toolkit.spring.boot.verification.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import org.toolkit.spring.boot.verification.validation.validator.IdCardValidator;

@Documented
@Constraint(validatedBy = IdCardValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdCard {
	String message() default "Invalid value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
