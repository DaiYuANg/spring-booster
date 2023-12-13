/* (C)2023*/
package org.nectar.nova.core;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.nectar.nova.core.document.MarkdownDocumentProcessor;

@TestWithResources
class MarkdownDocumentProcessorTest {

	@GivenTextResource("TestMarkdownDocumentProcessor.md")
	String instanceField;

	@Test
	void processor() {
		val html = new MarkdownDocumentProcessor().processor(instanceField);
		System.err.println(html.data());
	}
}
