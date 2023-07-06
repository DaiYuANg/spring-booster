package org.kop.libs.io.base;

import org.junit.jupiter.api.Test;

import java.io.File;

class DirTest {

    @Test
    void search() {
        System.err.println(System.getProperty("user.dir"));
        new Dir(new File(System.getProperty("user.dir"))).listFiles();
    }
}