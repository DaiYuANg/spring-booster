package org.toolkit.example.backend.minimal.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
public class BackendMinimalExample {
	public static void main(String[] args) {
		SpringApplication.run(BackendMinimalExample.class, args);
	}
}
