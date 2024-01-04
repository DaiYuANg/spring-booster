/* (C)2023*/
package org.spring.boost.verification.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.verification.annotation.Chinese;

@Slf4j
public class ChineseValidator implements ConstraintValidator<Chinese, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Validator.isChinese(value);
	}
}
