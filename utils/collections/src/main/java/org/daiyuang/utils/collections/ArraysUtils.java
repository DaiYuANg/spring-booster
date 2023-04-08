package org.daiyuang.utils.collections;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Experimental
@Log
@UtilityClass
public final class ArraysUtils {

    private final int useParallelSize = Integer.parseInt(
            System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism",
                    String.valueOf(Runtime.getRuntime().availableProcessors())
            )
    ) * 100;

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

    public static <T> Map<String, List<T>> grouping(List<T> l) {
        if (l.size() >= useParallelSize) {
            return l.parallelStream().collect(Collectors.groupingBy(T::toString));
        }
        return l.stream().collect(Collectors.groupingBy(T::toString));
    }
}
