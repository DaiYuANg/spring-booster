package org.toolkit4j.framework.spring.boot.starter.restful.validators;

import cn.hutool.core.util.IdcardUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.toolkit4j.framework.spring.boot.starter.restful.validators.annotations.IdCard;

public class IdCardValidator implements ConstraintValidator<IdCard, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return IdcardUtil.isValidCard(value);
    }
}
