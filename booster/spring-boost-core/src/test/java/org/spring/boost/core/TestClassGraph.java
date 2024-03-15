/* (C)2024*/
package org.spring.boost.core;

import io.github.classgraph.ClassGraph;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.spring.boost.core.autoconfigure.CoreAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
        classes = {CoreAutoConfiguration.class, TestClassScannerFeature.class},
        properties = {"spring.boost.enable-class-graph-log=true"})
@RunWith(SpringRunner.class)
final class TestClassGraph {

    @Resource
    private ClassGraph classGraph;

    @Test
    void boot() {
        System.err.println(classGraph);
    }
}
