package org.daiyuang.utils.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArraysUtilsTest {

    @Test
    void intersection() {
        var a = new int[]{12, 3, 31, 23};
        var b= new int[]{12, 5, 31, 23};
        ArraysUtils.intersection(a,b);
    }
}