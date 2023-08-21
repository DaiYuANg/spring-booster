package org.kop.framework.spring.starter.monitor;

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
public class CoreTest {

	// @Test
	// public void testBoot() {
	// System.err.println(123);
	// }
}
