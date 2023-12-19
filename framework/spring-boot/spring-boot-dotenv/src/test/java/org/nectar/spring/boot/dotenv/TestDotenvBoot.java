/* (C)2023*/
package org.nectar.spring.boot.dotenv;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = TestApplication.class)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.yaml")
public class TestDotenvBoot {
	@Autowired
	private ConfigurableEnvironment environment;

	@Test
	void testBoot() {
		Map<String, Object> properties = environment.getSystemProperties();
		for (PropertySource<?> propertySource : environment.getPropertySources()) {
			if (propertySource.getSource() instanceof Map) {
				@SuppressWarnings("unchecked")
				Map<String, Object> map = (Map<String, Object>) propertySource.getSource();
				properties.putAll(map);
			}
		}
		properties.forEach((k, v) -> {
			System.err.println(k);
			System.err.println(v);
		});
		System.err.println(environment.getProperty("spring.application.name"));
	}
}
