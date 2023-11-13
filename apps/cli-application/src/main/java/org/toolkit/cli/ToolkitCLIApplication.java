package org.toolkit.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.concurrent.Executors;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Slf4j
public class ToolkitCLIApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ToolkitCLIApplication.class, args);
		} catch (BeanCreationException beanCreationException) {
			log.error("{}", beanCreationException.getBeanName());
		}
	}
}
