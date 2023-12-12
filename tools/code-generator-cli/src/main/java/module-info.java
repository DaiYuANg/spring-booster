module jtoolkit.tools.cli {
    requires com.google.guice;
    requires static lombok;
    requires org.github.gestalt.core;
    requires org.github.gestalt.config.kotlin;
    requires org.fusesource.jansi;
    requires info.picocli;
    requires org.jetbrains.annotations;
    requires java.sql;
    requires jakarta.persistence;
    requires org.slf4j;
    requires jakarta.inject;
    requires java.compiler;
    requires com.squareup.javapoet;
    exports org.toolkit.cli.command to com.google.guice;
}
