/* (C)2023*/
package org.toolkit.cli.config;

import lombok.Getter;

@Getter
public class DefaultFileConfigProvider {

	private final String configFileName = "default.yaml";

//	@Override
//	public File getConfigFile() {
//		val url = this.getClass().getClassLoader().getResource(getConfigFileName());
//		return new File(Objects.requireNonNull(url, "Default Config file is not defined")
//				.getFile());
//	}
//
//	@Override
//	public Optional<ConfigSourcePackage> getConfigSource() {
//		return Optional.empty();
//	}
}
