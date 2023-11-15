package org.toolkit.spring.boot.verification.validator;

import jakarta.annotation.Resource;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.toolkit.spring.boot.verification.annotation.SomethingExistsInDatabase;

@Slf4j
public class SomethingExistsInDatabaseValidator implements ConstraintValidator<SomethingExistsInDatabase, String> {

	@Resource
	private JdbcTemplate jdbcTemplate;

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
