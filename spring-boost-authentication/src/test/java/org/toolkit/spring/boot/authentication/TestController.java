/* (C)2023*/
package org.toolkit.spring.boot.authentication;

import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.toolkit.spring.boot.authentication.annotation.IgnoreAuthentication;

@RestController
public class TestController {

	@GetMapping("/")
	@RequestMapping
	public void test() {}

	@GetMapping("/test")
	@IgnoreAuthentication
	@PermitAll
	public String testUn() {
		return "";
	}
}
