package org.toolkit.spring.boot.verification.validation.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.verification.validation.annotation.Chinese;

@Slf4j
public class ChineseValidator implements ConstraintValidator<Chinese, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Validator.isChinese(value);
	}
}