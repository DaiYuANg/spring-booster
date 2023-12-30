/* (C)2023*/
package org.toolkit.spring.boot.verification.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;
import org.toolkit.spring.boot.verification.validator.SomethingExistsInDatabaseValidator;

@Documented
@Constraint(validatedBy = SomethingExistsInDatabaseValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SomethingExistsInDatabase {
	String message() default "{jakarta.validation.constraints.NotBlank.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String table();

	String whereCondition();
}
