package org.kop.libs.kernel.collections;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

@Experimental
@Slf4j
@UtilityClass
public final class ListHelper {

    @Contract(pure = true)
    public static <T> T @Nullable [] intersection(T @NotNull [] listOfOne, T[] listOfAnother) {
        var result = new Object[listOfOne.length];
        for (T t : listOfOne) {
            for (T t1 : listOfAnother) {
                if (t.equals(t1)) result[1] = t;
            }
        }
        return null;
    }

    @Contract(pure = true)
    public static <T> @Nullable List<T> intersection(List<T> listOfOne, List<T> listOfAnother) {
//        var a = new HashSet<>(listOfOne);
//        var b = new HashSet<>(listOfAnother);
//        a.retainAll(b);
//        System.err.println(new ArrayList<>(a));
        return null;
    }

    public static <T> Map<String, List<T>> grouping(@NotNull List<T> l) {
        log.info("l size:{}", l.size());
        return l.stream().collect(Collectors.groupingBy(T::toString));
    }

    @SafeVarargs
    public static <T> List<T> merge(boolean removeDuplicate, List<T>... lists) {
        var stream = Arrays.stream(lists).flatMap(Collection::stream);
        if (removeDuplicate) return stream.distinct().toList();
        return stream.collect(Collectors.toList());
    }

    public static <T> Optional<T> searchEq(@NotNull List<T> source, T target) {
        if (!source.contains(target)) return Optional.empty();
        return source.stream().filter(s -> s.equals(target)).findAny();
    }

    public static <T> T searchEqNullAble(@NotNull List<T> source, T target) {
        return searchEq(source, target).orElse(null);
    }

    @SafeVarargs
    public static <T> List<T> merge(List<T>... lists) {
        return merge(true, lists);
    }
}
