package org.toolkit.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executors;

@SpringBootApplication(scanBasePackages = "org.toolkit.example.**.*")
@EnableAsync
@EnableJpaRepositories("org.toolkit.example.**.*")
@EntityScan("org.toolkit.example.**.*")
public class ExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
	}
}
