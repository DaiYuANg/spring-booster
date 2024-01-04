/* (C)2023*/
package org.spring.boost.verification.validator;

import cn.hutool.extra.spring.SpringUtil;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.verification.annotation.SomethingExistsInDatabase;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
public class SomethingExistsInDatabaseValidator implements ConstraintValidator<SomethingExistsInDatabase, String> {

    private final JdbcTemplate jdbcTemplate = SpringUtil.getBean(JdbcTemplate.class);

    private String table;

    private String whereCondition;

    @Override
    public void initialize(@NotNull SomethingExistsInDatabase constraintAnnotation) {
        this.whereCondition = constraintAnnotation.whereCondition();
        this.table = constraintAnnotation.table();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        val sql = "select count(*) ? where ?=?";
        val query = jdbcTemplate.queryForObject(sql, Integer.class, table, whereCondition, value);
        return Objects.isNull(query) || query > 0;
    }
}
