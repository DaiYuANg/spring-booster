package org.toolkit.spring.boot.dev.service.core;

import org.inferred.freebuilder.FreeBuilder;

@FreeBuilder
public interface Container {

	class Builder extends Container_Builder {}
}
