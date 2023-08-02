package org.toolkit.spring.boot.starter.monitor.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

	@GetMapping("/querySystemInfo")
	public void querySystemInfo() {}
}
