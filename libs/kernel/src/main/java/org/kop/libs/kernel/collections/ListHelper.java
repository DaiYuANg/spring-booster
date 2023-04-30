package org.kop.libs.kernel.collections;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Experimental
@Slf4j
@UtilityClass
public final class ListHelper {

    public static <T> T[] intersection(T[] listOfOne, T[] listOfAnother) {
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
        log.info("l size:{}", l.size());
        return l.stream().collect(Collectors.groupingBy(T::toString));
    }

    @SafeVarargs
    public static <T> List<T> merge(boolean removeDuplicate, List<T>... lists) {
        var stream = Arrays.stream(lists).flatMap(Collection::stream);
        if (removeDuplicate) return stream.distinct().toList();
        return stream.collect(Collectors.toList());
    }

    @SafeVarargs
    public static <T> List<T> merge(List<T>... lists) {
        return merge(true, lists);
    }
}
