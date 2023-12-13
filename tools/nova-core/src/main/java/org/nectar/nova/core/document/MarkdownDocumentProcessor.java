/* (C)2023*/
package org.nectar.nova.core.document;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MarkdownDocumentProcessor implements DocumentProcessor {
	@Override
	public Document processor(String source) {
		MutableDataSet options = new MutableDataSet();
		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();
		Node document = parser.parse(source);
		String html = renderer.render(document);
		System.err.println(html);
		return Jsoup.parse(html);
	}
}
