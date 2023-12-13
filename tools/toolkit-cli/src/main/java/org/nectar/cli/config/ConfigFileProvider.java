/* (C)2023*/
package org.nectar.cli.config;

import org.github.gestalt.config.source.ConfigSourcePackage;

public interface ConfigFileProvider {

	ConfigSourcePackage getSourcePackage();
}
