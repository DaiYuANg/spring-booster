package org.toolkit4j.framework.spring.boot.starter.restful.validations.validators;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.toolkit4j.framework.spring.boot.starter.restful.validations.annotations.ChineseName;

public class ChineseNameValidator implements ConstraintValidator<ChineseName, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Validator.isChineseName(value);
    }
}
