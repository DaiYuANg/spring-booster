package org.kop.libs.helpers.collections;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Experimental
@Slf4j
@UtilityClass
public final class ListHelper {
    public static <T, K> Map<K, List<T>> grouping(@NotNull List<T> l, Function<? super T, ? extends K> classifier) {
        log.info("l size:{}", l.size());
        return l.stream().collect(Collectors.groupingBy(classifier));
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

    public static <T> List<T> intersection(@NotNull List<T> list1, @NotNull List<T> list2) {
        return list1.stream().filter(list2::contains).collect(Collectors.toList());
    }

    @Contract("_, _ -> new")
    public static <T extends CharSequence> @NotNull String listToString(List<T> list, CharSequence separator) {
        return String.join(separator, list);
    }

    @SafeVarargs
    public static <T> List<T> merge(List<T>... lists) {
        return merge(true, lists);
    }
}
