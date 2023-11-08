package org.toolkit.spring.boot.starter.restful;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit.spring.boot.starter.restful.annotations.AllowClient;
import org.toolkit.spring.boot.starter.restful.constant.ClientDevice;
import org.toolkit.spring.boot.starter.restful.validations.annotations.NotChinese;

@RestController
@Slf4j
@Validated
public class TestController {

	@GetMapping("/")
	@AllowClient(device = ClientDevice.ALL)
	public String test(@Valid @RequestParam @NotChinese String test) {
		log.info(test);
		return "test controller";
	}
}
