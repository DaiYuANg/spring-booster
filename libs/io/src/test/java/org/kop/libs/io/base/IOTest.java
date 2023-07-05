package org.kop.libs.io.base;

import org.junit.jupiter.api.Test;
import org.kop.libs.io.impl.LocalFS;

class IOTest {

    @Test
    void touch() {
        new LocalFS(System.getProperty("user.dir"));
        IOManager.builder().build();
    }
}