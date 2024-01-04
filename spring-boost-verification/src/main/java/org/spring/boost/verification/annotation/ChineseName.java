/* (C)2023*/
package org.spring.boost.verification.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

import org.spring.boost.verification.validator.ChineseNameValidator;

@Documented
@Constraint(validatedBy = ChineseNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChineseName {
	String message() default "{jakarta.validation.constraints.NotBlank.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
