/* (C)2024*/
package org.spring.boost.authentication;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.spring.boost.authentication.configuration.AuthenticationAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.test.context.junit4.SpringRunner;

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
