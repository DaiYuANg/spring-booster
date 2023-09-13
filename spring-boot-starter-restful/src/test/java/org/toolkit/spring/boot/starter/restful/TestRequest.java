package org.toolkit.spring.boot.starter.restful;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit.spring.boot.starter.restful.configurations.RestfulAutoConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {SpringBootApplication.class, RestfulAutoConfiguration.class})
@RunWith(SpringRunner.class)
public class TestRequest {

    @Test
    public void testStart() {
        System.err.println("start");
    }
}
