package org.toolkit4j.libs.helpers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lombok.experimental.UtilityClass;
import lombok.val;

@UtilityClass
public class ListHelper {
	@SafeVarargs
	public static <T> List<T> merge(boolean duplicate, List<T>... lists) {
		val stream = Arrays.stream(lists).flatMap(Collection::stream);
		return duplicate ? stream.distinct().toList() : stream.toList();
	}

	@SafeVarargs
	public static <T> List<T> merge(List<T>... lists) {
		return merge(true, lists);
	}
}
