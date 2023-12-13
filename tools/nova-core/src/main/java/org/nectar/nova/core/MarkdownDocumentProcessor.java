/* (C)2023*/
package org.nectar.nova.core;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownDocumentProcessor implements DocumentProcessor {

	static {
		MutableDataSet options = new MutableDataSet();
		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();
	}

	@Override
	public void processor(String source) {}
}
