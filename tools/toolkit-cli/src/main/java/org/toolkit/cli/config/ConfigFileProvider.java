/* (C)2023*/
package org.toolkit.cli.config;

import org.github.gestalt.config.source.ConfigSourcePackage;

import java.io.File;
import java.util.Optional;

public interface ConfigFileProvider {
	String getConfigFileName();

	Optional<ConfigSourcePackage> getConfigSource();
}
