/* (C)2024*/
package org.spring.boost.example;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EnableJpaRepositories("org.spring.boost.example.repository")
//@EnableJpaAuditing
@EntityScan
//@EnableAdminServer
@OpenAPIDefinition(
  info = @Info(
    title = "My API",
    description = "API documentation for my application",
    version = "1.0"
  )
)
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
