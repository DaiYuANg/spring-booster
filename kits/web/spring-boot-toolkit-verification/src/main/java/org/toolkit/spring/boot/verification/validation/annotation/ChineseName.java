package org.toolkit.spring.boot.verification.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import org.toolkit.spring.boot.verification.validation.validator.ChineseNameValidator;

@Documented
@Constraint(validatedBy = ChineseNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChineseName {
	String message() default "{jakarta.validation.constraints.NotBlank.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
