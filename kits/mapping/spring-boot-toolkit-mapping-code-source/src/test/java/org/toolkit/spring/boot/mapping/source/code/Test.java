package org.toolkit.spring.boot.mapping.source.code;

import java.math.BigDecimal;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;

public class Test {

	@StaticField("test_field")
	private static final String test = "test";

	@StaticField("test_field_big_decimal")
	private static final BigDecimal test1 = BigDecimal.ZERO;
}
