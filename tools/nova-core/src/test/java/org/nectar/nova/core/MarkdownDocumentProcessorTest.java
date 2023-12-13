/* (C)2023*/
package org.nectar.nova.core;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import org.junit.jupiter.api.Test;

class MarkdownDocumentProcessorTest {

	@Test
	void processor() {
		String path = "src/test/resources/TestMarkdownDocumentProcessor.md";

		File file = new File(path);
		String absolutePath = file.getAbsolutePath();

		System.out.println(absolutePath);
	}
}
