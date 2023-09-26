package org.toolkit.example.backend.minimal.example;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@Resource
	ExampleEntityRepository exampleEntityRepository;

	@GetMapping("/test")
	public void test() {
		ExampleEntity entity = new ExampleEntity().setTestField("test");
		exampleEntityRepository.save(entity);
	}
}
