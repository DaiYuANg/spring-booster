/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.scanner;

import io.github.classgraph.ClassGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaticFieldApplicationPreparedListenerTest {
	private ClassGraph classGraph;

	@BeforeEach
	public void setup() {
		classGraph = new ClassGraph()
				.verbose(false)
				.enableAllInfo()
				.acceptPackages("org.toolkit.spring.boot.mapping.source.code");
	}

	@Test
	public void testScanner() {}
}