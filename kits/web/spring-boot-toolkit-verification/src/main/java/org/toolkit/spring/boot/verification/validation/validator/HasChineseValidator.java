package org.toolkit.spring.boot.verification.validation.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.verification.validation.annotation.HasChinese;

@Slf4j
public class HasChineseValidator implements ConstraintValidator<HasChinese, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Validator.hasChinese(value);
	}
}
