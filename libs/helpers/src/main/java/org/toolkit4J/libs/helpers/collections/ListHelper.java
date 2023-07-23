package org.toolkit4J.libs.helpers.collections;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@UtilityClass
public class ListHelper {

    public static <T> List<T> merge(@NotNull List<List<T>> lists) {
        return lists.stream().flatMap(Collection::stream).toList();
    }

    public static <T> List<T> merge(List<T>... lists) {
        return merge(Arrays.stream(lists).toList());
    }
}
