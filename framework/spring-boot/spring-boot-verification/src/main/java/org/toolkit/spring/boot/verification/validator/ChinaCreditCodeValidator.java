/* (C)2023*/
package org.toolkit.spring.boot.verification.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.verification.annotation.ChinaCreditCode;

@Slf4j
public class ChinaCreditCodeValidator implements ConstraintValidator<ChinaCreditCode, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Validator.isCreditCode(value);
	}
}
