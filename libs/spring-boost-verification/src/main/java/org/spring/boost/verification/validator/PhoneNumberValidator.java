/* (C)2023*/
package org.spring.boost.verification.validator;

import cn.hutool.core.util.PhoneUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.verification.annotation.PhoneNumber;

@Slf4j
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        log.debug("phone validator validating:{}", value);
        return PhoneUtil.isPhone(value);
    }
}
