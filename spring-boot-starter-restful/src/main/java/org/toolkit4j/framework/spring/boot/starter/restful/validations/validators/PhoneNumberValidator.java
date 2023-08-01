package org.toolkit4j.framework.spring.boot.starter.restful.validations.validators;

import cn.hutool.core.util.PhoneUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations.PhoneNumber;

@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		log.debug("phone validator validating:{}", value);
		return PhoneUtil.isPhone(value);
	}
}
