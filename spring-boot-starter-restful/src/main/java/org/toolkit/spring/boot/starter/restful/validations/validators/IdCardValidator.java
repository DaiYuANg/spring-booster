package org.toolkit.spring.boot.starter.restful.validations.validators;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.starter.restful.validations.annotations.IdCard;

@Slf4j
public class IdCardValidator implements ConstraintValidator<IdCard, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		log.debug("id card validator validating:{}", value);
		return Validator.isCitizenId(value);
	}
}