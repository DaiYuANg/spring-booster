/* (C)2023*/
package org.toolkit.cli.config;

import java.io.File;
import java.util.Objects;
import lombok.Getter;
import lombok.val;

@Getter
public class DefaultToolkitCliConfigFile implements ToolkitCliConfig {

	private final String configFileName = "default.yaml";

	@Override
	public File getConfigFile() {
		val url = this.getClass().getClassLoader().getResource(getConfigFileName());
		return new File(Objects.requireNonNull(url, "Default Config file is not defined")
				.getFile());
	}
}
