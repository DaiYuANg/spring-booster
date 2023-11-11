package org.toolkit.spring.boot.web.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Validated
public class TestController {

	//	@GetMapping("/")
	//	@AllowClient(device = ClientDevice.ALL)
	//	public String test(@Valid @RequestParam @NotChinese String test) {
	//		log.info(test);
	//		return "test controller";
	//	}
}
