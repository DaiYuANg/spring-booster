package org.toolkit.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ToolkitCLIApplication {

	public static void main(String[] args) {
		System.setProperty("org.jline.terminal.dumb", "true");
		SpringApplication.run(ToolkitCLIApplication.class, args);
	}
}
