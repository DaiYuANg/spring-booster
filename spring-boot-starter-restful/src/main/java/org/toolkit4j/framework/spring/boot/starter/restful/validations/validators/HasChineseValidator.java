package org.toolkit4j.framework.spring.boot.starter.restful.validations.validators;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations.HasChinese;

public class HasChineseValidator implements ConstraintValidator<HasChinese, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Validator.hasChinese(value);
	}
}
