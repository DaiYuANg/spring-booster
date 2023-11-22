package org.toolkit.spring.boot.mapping.source.code;

import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.mapping.core.structure.MappingItem;
import org.toolkit.spring.boot.mapping.source.code.annotation.EnumMapping;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticField;

@EnumMapping
public enum Test implements MappingItem<String> {
    A("texxt", "dsa"),

    B("1aa", "11");

    @StaticField("test_field")
    static final String test = "test";

    Test(String texxt, String dsa) {
        this.text = texxt;
        this.value = dsa;
    }

    private final String value;

    private final String text;

    @Override
    public @NotNull String value() {
        return this.value;
    }

    @Override
    public @NotNull String text() {
        return this.text;
    }
}
