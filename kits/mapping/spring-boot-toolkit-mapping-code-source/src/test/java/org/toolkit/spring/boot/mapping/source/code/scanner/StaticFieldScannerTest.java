package org.toolkit.spring.boot.mapping.source.code.scanner;

import io.github.classgraph.ClassGraph;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

class StaticFieldScannerTest {
    private ClassGraph classGraph;


    @BeforeEach
    public void setup(){
       classGraph = new ClassGraph().verbose(false).enableAllInfo()
               .acceptPackages("org.toolkit.spring.boot.mapping.source.code");
    }

    @Test
    public void testScanner(){
        val scanResult = new StaticFieldScanner(classGraph).scan();
        System.err.println(scanResult);
    }
}