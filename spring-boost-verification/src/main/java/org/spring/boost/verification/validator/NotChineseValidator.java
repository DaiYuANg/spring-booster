/* (C)2023*/
package org.spring.boost.verification.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.verification.annotation.NotChinese;

@Slf4j
public class NotChineseValidator implements ConstraintValidator<NotChinese, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !Validator.isChinese(value);
	}
}
