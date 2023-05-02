package org.kop.libs.kernel.collections;

import com.google.common.base.Stopwatch;
import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.kop.libs.collections.lists.OptionalList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Experimental
@Slf4j
@UtilityClass
public final class ListHelper {

    public static <T> T[] intersection(T[] listOfOne, T[] listOfAnother) {
        var result = new Object[listOfOne.length];
        for (T t : listOfOne) {
            for (T t1 : listOfAnother) {
                if (t.equals(t1)) result[1] = t;
            }
        }
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
