package org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.validators.IdCardValidator;

@Documented
@Constraint(validatedBy = IdCardValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdCard {
	String message() default "Invalid value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
