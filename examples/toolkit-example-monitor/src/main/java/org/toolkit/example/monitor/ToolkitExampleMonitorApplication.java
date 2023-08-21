package org.toolkit.example.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.toolkit.example"})
public class ToolkitExampleMonitorApplication {
	public static void main(String[] args) {
		SpringApplication.run(ToolkitExampleMonitorApplication.class, args);
	}
}
