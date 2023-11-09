package org.toolkit.spring.boot.web.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit.spring.boot.web.core.configurations.RestfulAutoConfiguration;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = {SpringBootApplication.class, RestfulAutoConfiguration.class})
@RunWith(SpringRunner.class)
public class TestRequest {

	@Test
	public void testStart() {
		System.err.println("start");
	}
}
