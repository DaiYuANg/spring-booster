package org.toolkit.example.backend.minimal.example;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit.spring.boot.authentication.annotation.IgnoreAuthentication;

@RestController
@Slf4j
public class ExampleController {

	@Resource
	ExampleEntityRepository exampleEntityRepository;

	@GetMapping("/test")
	@IgnoreAuthentication
	public String test() {
		val entity = new ExampleEntity().setTestField("test");
		exampleEntityRepository.save(entity);
		return "ok";
	}
}
