package org.daiyuang.utils.collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ArraysUtilsTest {

    @Test
    void intersection() {
        var a = new int[]{12, 3, 31, 23};
        var b = new int[]{12, 5, 31, 23};
        ArraysUtils.intersection(a, b);
    }

    @Test
    void grouping() {
        var arra = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            arra.add(i);
        }
        var r = ArraysUtils.grouping(List.of(arra));
        System.err.println(r);
    }
}