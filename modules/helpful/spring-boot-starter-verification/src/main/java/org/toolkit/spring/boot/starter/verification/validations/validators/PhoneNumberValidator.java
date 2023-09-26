package org.toolkit.spring.boot.starter.verification.validations.validators;

import cn.hutool.core.util.PhoneUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.starter.verification.validations.annotations.PhoneNumber;

@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		log.debug("phone validator validating:{}", value);
		return PhoneUtil.isPhone(value);
	}
}
