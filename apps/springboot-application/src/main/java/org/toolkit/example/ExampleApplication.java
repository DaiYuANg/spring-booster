/* (C)2023*/
package org.toolkit.example;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = "org.toolkit.example.**.*")
@EnableAsync
@EnableJpaRepositories("org.toolkit.example.**.*")
@EntityScan("org.toolkit.example.**.*")
@Slf4j
public class ExampleApplication {
	public static void main(String[] args) {
		val app = new SpringApplication(ExampleApplication.class);
		app.setApplicationStartup(new BufferingApplicationStartup(10000));
		app.run(args);
	}
}
