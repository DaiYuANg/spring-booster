/* (C)2024*/
package org.toolkit.spring.boot.authentication;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit.spring.boot.authentication.configuration.AuthenticationAutoConfiguration;

@SpringBootTest(
		classes = {
			TestController.class,
			AuthenticationAutoConfiguration.class,
			TestApplication.class,
			ServletWebServerFactory.class
		},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TestPermit {

	@Resource
	private TestController testController;

	@Test
	public void test() {}
}
