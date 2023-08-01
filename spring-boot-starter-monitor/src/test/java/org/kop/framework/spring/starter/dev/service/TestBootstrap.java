package org.kop.framework.spring.starter.dev.service;

import org.junit.runner.RunWith;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = WavefrontProperties.Application.class)
@TestPropertySource("classpath:application.yaml")
@RunWith(SpringRunner.class)
public class TestBootstrap {
	// @Resource
	// private DockerConnector dockerConnector;

	// @Test
	// public void testStart() {
	// System.err.println(123);
	// }
}
