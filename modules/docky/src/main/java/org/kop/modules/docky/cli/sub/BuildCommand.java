package org.kop.modules.docky.cli.sub;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import picocli.CommandLine;

@CommandLine.Command(name = "build")
public class BuildCommand {
    public static void main(String[] args) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse("This is *Sparta*");
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        var a = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
        System.err.println(a);
    }
}
