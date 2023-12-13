/* (C)2023*/
package org.nectar.cli.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ConfigFileType {
	YAML("yaml"),

	TOML("toml"),

	JSON("json");

	private final String type;
}
