package org.toolkit4J.libs.helpers.collections;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@UtilityClass
public class ListHelper {

    @SafeVarargs
    public static <T> List<T> merge(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).toList();
    }
}
