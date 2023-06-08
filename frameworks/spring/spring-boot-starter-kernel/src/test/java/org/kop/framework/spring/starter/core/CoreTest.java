package org.kop.framework.spring.starter.core;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CoreApp.class
)
@TestPropertySource("classpath:application.yaml")
@RunWith(SpringRunner.class)
public class CoreTest {

    @Test
    public void testBoot() {

    }
}
