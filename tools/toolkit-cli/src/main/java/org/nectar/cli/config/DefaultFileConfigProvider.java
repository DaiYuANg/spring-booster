/* (C)2023*/
package org.nectar.cli.config;

import java.io.File;
import java.util.Objects;
import java.util.Optional;
import lombok.Getter;
import lombok.val;
import org.github.gestalt.config.source.ConfigSourcePackage;

@Getter
public class DefaultFileConfigProvider implements ConfigFileProvider {

	private final String configFileName = "default.yaml";

	private final File file;

	{
		val url = this.getClass().getClassLoader().getResource(configFileName);
		this.file = new File(Objects.requireNonNull(url).getFile());
	}

	public Optional<File> getFile() {
		return Optional.empty();
	}

	public Optional<ConfigSourcePackage> getConfigSource() {
		return Optional.empty();
	}

	@Override
	public ConfigSourcePackage getSourcePackage() {
		return null;
	}
}
