/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code;

import java.math.BigDecimal;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;

public class Test {

    @StaticField(key = "test_field")
    private static final String test = "test";

    @StaticField(key = "test_field_big_decimal")
    private static final BigDecimal test1 = BigDecimal.ZERO;
}
