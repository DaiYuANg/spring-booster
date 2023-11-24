package org.toolkit.spring.boot.mapping.source.code;

import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.mapping.core.structure.MappingItem;
import org.toolkit.spring.boot.mapping.source.code.annotation.EnumMapping;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;

import java.math.BigDecimal;

public class Test {

    @StaticField("test_field")
    private static final String test = "test";

    @StaticField("test_field_big_decimal")
    private static final BigDecimal test1 = BigDecimal.ZERO;
}
