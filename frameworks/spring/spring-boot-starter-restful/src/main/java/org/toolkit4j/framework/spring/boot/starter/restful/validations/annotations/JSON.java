package org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations;

import jakarta.validation.Constraint;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.validators.JSONValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = JSONValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSON {
}
