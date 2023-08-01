package org.toolkit4j.framework.spring.boot.starter.restful.validations.validators;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations.NotChinese;

public class NotChineseValidator implements ConstraintValidator<NotChinese, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !Validator.isChinese(value);
	}
}
