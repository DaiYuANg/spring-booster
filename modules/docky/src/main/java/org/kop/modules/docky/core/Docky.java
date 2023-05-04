package org.kop.modules.docky.core;

import com.google.common.io.Resources;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import dagger.Component;
import dagger.Module;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Builder;
import lombok.SneakyThrows;
import org.daiyuang.libs.io.dir.Walker;
import org.kop.modules.docky.DockyMain;

import java.io.File;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;

@Builder
@ApplicationScoped
public class Docky {
    @Inject
    public Docky() {
    }

    @SneakyThrows
    Docky(Path path) {
//        this.where = path;
        System.err.println(new File("./docky").exists());
        System.err.println(Path.of(DockyMain.class.getResource("/docky").toURI()).toFile().isDirectory());
//        var options = new MutableDataSet();
//        Parser parser = Parser.builder(options).build();
//        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
//
//         You can re-use parser and renderer instances
//        Node document = parser.parse(Files.readString(where));
//        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
//        System.err.println(html);
//        System.err.println(new File(where.toUri()));
    }
}
