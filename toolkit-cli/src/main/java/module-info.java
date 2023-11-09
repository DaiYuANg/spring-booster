module org.toolkit.cli {
	requires org.slf4j;
	requires static lombok;
	requires org.fusesource.jansi;
	requires info.picocli;
	requires jakarta.inject;
	requires com.google.guice;
	requires com.squareup.javapoet;
	requires freemarker;
    requires java.compiler;
	requires org.github.gestalt.core;
	requires org.github.gestalt.json;
	requires org.github.gestalt.toml;
	requires org.github.gestalt.git;
	requires org.github.gestalt.yaml;
	requires java.sql;
	requires org.apache.commons.dbutils;
	requires org.apache.commons.io;

    opens org.toolkit.cli.command to
			info.picocli;
	opens org.toolkit.cli to
			com.google.guice;

	exports org.toolkit.cli.di;
	exports org.toolkit.cli.command;
	exports org.toolkit.cli;
}
