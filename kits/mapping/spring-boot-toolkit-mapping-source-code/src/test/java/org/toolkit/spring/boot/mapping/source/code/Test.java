package org.toolkit.spring.boot.mapping.source.code;

import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.mapping.core.structure.MappingItem;
import org.toolkit.spring.boot.mapping.source.code.annotation.EnumMapping;

@EnumMapping
public enum Test implements MappingItem {
	A("texxt", "dsa"),

	B("1aa", "11");

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
