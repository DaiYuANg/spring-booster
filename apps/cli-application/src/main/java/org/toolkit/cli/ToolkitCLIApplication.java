package org.toolkit.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Slf4j
public class ToolkitCLIApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolkitCLIApplication.class, args);
	}
}
