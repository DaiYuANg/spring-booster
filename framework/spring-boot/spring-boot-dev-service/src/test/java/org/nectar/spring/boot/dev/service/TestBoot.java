/* (C)2023*/
package org.nectar.spring.boot.dev.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class TestBoot {

	@Test
	void testBoot() {
		System.err.println("123");
	}
}
