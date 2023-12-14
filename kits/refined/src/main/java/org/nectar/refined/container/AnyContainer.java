/* (C)2023*/
package org.nectar.refined.container;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AnyContainer<T extends Containerizeable> extends BasicContainer<T, AnyContainer<T>> {

	protected AnyContainer(T value) {
		super(value);
	}

	@Override
	public AnyContainer<T> filter(@NotNull Predicate<T> predicate) {
		return isValid() ? this : predicate.test(value) ? this : empty();
	}

	@Override
	public <U extends Container<T, ?>> AnyContainer<T> map(@NotNull Function<? super T, U> mapper) {
		if (isValid()) {
			return empty();
		} else {
			@SuppressWarnings("unchecked")
			val result = (AnyContainer<T>) mapper.apply(value);
			return result;
		}
	}

	@Override
	public <U> AnyContainer<T> flatMap(@NotNull Function<? super T, ? extends Container<T, ? extends U>> mapper) {
		if (isValid()) {
			return empty();
		} else {
			@SuppressWarnings("unchecked")
			val r = (AnyContainer<T>) mapper.apply(value);
			return r;
		}
	}

	@SneakyThrows
	@Override
	public T orElseThrow() {
		throw value.exception();
	}

	@Override
	public T get() {
		return value;
	}

	@Override
	public AnyContainer<T> or(@NotNull Supplier<AnyContainer<T>> supplier) {
		return isValid() ? supplier.get() : this;
	}

	@Override
	public boolean isValid() {
		return super.isValid() && value.isValid();
	}

	@NotNull @Contract("_ -> new")
	public static <T extends Containerizeable> AnyContainer<T> of(T value) {
		return new AnyContainer<>(value);
	}

	@NotNull public static <T extends Containerizeable> AnyContainer<T> empty() {
		return new AnyContainer<>(null);
	}
}
