package org.toolkit.docs.gen;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class MarkdownDocumentProcessor implements DocumentProcessor {

	{
		MutableDataSet options = new MutableDataSet();
		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();
	}

	@Override
	public void processor() {}
}
