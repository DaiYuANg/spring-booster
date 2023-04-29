package org.daiyuang.kernel.collections;

import org.daiyuang.collections.tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        new TreeNode<String>();
        System.err.println(arra.size());
        var r = ArraysUtils.grouping(arra);
        System.err.println(r);
    }
}