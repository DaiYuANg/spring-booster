/* (C)2023*/
package org.nectar.refined.container;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.EqualsAndHashCode;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nectar.refined.exception.StringEmptyOrBlank;

@EqualsAndHashCode(callSuper = true)
public class StringContainer extends BasicContainer<String, StringContainer> {

	protected StringContainer(String value) {
		super(value);
	}

	@Override
	public StringContainer filter(Predicate<String> predicate) {
		return isEmpty() ? this : predicate.test(value) ? this : empty();
	}

	@Override
	public <U extends Container<String, ?>> StringContainer map(Function<? super String, U> mapper) {
		return isEmpty() ? empty() : (StringContainer) mapper.apply(value);
	}

	@Override
	public <U> StringContainer flatMap(Function<? super String, ? extends Container<String, ? extends U>> mapper) {
		if (isEmpty()) {
			return empty();
		} else {
			val r = mapper.apply(value);
			return (StringContainer) r;
		}
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty() && value.isEmpty() && value.isBlank();
	}

	@NotNull @Contract(" -> new")
	public static StringContainer empty() {
		return new StringContainer("");
	}

	@Override
	public String orElseThrow() {
		if (isEmpty()) throw new StringEmptyOrBlank();
		return value;
	}

	@Override
	public String get() throws StringEmptyOrBlank {
		return orElseGet(() -> {
			throw new StringEmptyOrBlank();
		});
	}

	@Override
	public StringContainer or(Supplier<StringContainer> supplier) {
		return isEmpty() ? supplier.get() : this;
	}

	@Contract("_ -> new")
	@NotNull public static StringContainer of(@Nullable String value) {
		return new StringContainer(value);
	}
}
