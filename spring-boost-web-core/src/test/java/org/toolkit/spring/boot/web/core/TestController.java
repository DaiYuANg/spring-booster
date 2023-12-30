/* (C)2023*/
package org.toolkit.spring.boot.web.core;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
public class TestController {

	@GetMapping("/")
	public String test(@Valid @RequestParam(required = false) String test) {
		log.info(test);
		return "test controller";
	}
}
