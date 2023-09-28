package org.toolkit.spring.boot.starter.verification.validations.validators;

import cn.hutool.json.JSONUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.starter.verification.validations.annotations.JSON;

@Slf4j
public class JSONValidator implements ConstraintValidator<JSON, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return JSONUtil.isTypeJSON(value);
	}
}