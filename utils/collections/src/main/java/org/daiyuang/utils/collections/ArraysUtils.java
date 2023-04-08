package org.daiyuang.utils.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArraysUtils {
    public static int[] intersection(int[] listOfOne, int[] listOfAnother) {
        System.err.println(Arrays.toString(listOfAnother));
        System.err.println(Arrays.toString(listOfOne));
        var a = new ArrayList<>(List.of(listOfOne));
        var b = new ArrayList<>(List.of(listOfAnother));
        b.retainAll(a);
        a.forEach(System.err::println);
        System.err.println(Arrays.toString(a.toArray()));
        return null;
    }

    public static <T> List<T> intersection(List<T> listOfOne, List<T> listOfAnother) {
//        var a = new HashSet<>(listOfOne);
//        var b = new HashSet<>(listOfAnother);
//        a.retainAll(b);
//        System.err.println(new ArrayList<>(a));
        return null;
    }
}
