/* (C)2023*/
package org.nectar.refined.container;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nectar.refined.exception.StringEmptyOrBlank;

public class StringContainer extends BasicContainer<String, StringContainer> {

	protected StringContainer(String value) {
		super(value);
	}

	@Override
	public StringContainer filter(@NotNull Predicate<String> predicate) {
		return isValid() ? this : predicate.test(value) ? this : empty();
	}

	@Override
	public <U extends Container<String, ?>> StringContainer map(@NotNull Function<? super String, U> mapper) {
		return isValid() ? empty() : (StringContainer) mapper.apply(value);
	}

	@Override
	public <U> StringContainer flatMap(
			@NotNull Function<? super String, ? extends Container<String, ? extends U>> mapper) {
		if (isValid()) {
			return empty();
		} else {
			val r = mapper.apply(value);
			return (StringContainer) r;
		}
	}

	@Override
	public boolean isValid() {
		return super.isValid() && value.isEmpty() && value.isBlank();
	}

	@NotNull @Contract(" -> new")
	public static StringContainer empty() {
		return new StringContainer("");
	}

	@Override
	public String orElseThrow() {
		if (isValid()) throw new StringEmptyOrBlank();
		return value;
	}

	@Override
	public String get() throws StringEmptyOrBlank {
		return orElseGet(() -> {
			throw new StringEmptyOrBlank();
		});
	}

	@Override
	public StringContainer or(@NotNull Supplier<StringContainer> supplier) {
		return isValid() ? supplier.get() : this;
	}

	@Contract("_ -> new")
	@NotNull public static StringContainer of(@Nullable String value) {
		return new StringContainer(value);
	}
}
