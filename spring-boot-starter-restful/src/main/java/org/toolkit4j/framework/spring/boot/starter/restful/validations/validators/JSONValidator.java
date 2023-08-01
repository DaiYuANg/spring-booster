package org.toolkit4j.framework.spring.boot.starter.restful.validations.validators;

import cn.hutool.json.JSONUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations.JSON;

@Slf4j
public class JSONValidator implements ConstraintValidator<JSON, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return JSONUtil.isTypeJSON(value);
	}
}
