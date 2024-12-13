/* (C)2023*/
package org.spring.boost.verification.validator;

import cn.hutool.core.lang.Validator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.verification.annotation.HasChinese;

@Slf4j
public class HasChineseValidator implements ConstraintValidator<HasChinese, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Validator.hasChinese(value);
    }
}
