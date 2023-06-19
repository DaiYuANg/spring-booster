package org.kop.framework.spring.starter.dev.service;

import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kop.framework.spring.starter.dev.service.docker.DockerConnector;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.yaml")
public class TestBootstrap {
    @Resource
    private DockerConnector dockerConnector;

    @Test
    public void testStart() {
        System.err.println(123);
    }
}
