package org.toolkit.spring.boot.verification.validation.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.verification.validation.annotation.ChineseName;

@Slf4j
public class ChineseNameValidator implements ConstraintValidator<ChineseName, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Validator.isChineseName(value);
	}
}
