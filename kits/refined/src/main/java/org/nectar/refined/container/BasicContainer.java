/* (C)2023*/
package org.nectar.refined.container;

import static java.util.Optional.ofNullable;
import static java.util.stream.Stream.of;

import java.io.Serial;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;

public abstract class BasicContainer<T, I extends BasicContainer<T, I>> implements Container<T, I> {

	@Serial
	private static final long serialVersionUID = 1L;

	protected final T value;

	protected BasicContainer(T value) {
		this.value = value;
	}

	@Override
	public Stream<T> stream() {
		return of(value);
	}

	@Override
	public Optional<T> toOptional() {
		return ofNullable(value);
	}

	@SuppressWarnings("IsNull")
	@Override
	public boolean isValid() {
		return Objects.isNull(value);
	}

	@Override
	public CompletableFuture<T> toCompletableFuture() {
		return CompletableFuture.supplyAsync(() -> value);
	}

	@Override
	@SneakyThrows
	public <ErrorException extends Exception> T orElseThrow(@NotNull Class<ErrorException> errorExceptionClass) {
		if (isValid()) throw errorExceptionClass.getDeclaredConstructor().newInstance();
		return value;
	}

	@Override
	public <ErrorException extends Exception> T orElseThrow(
			@NotNull Supplier<? extends ErrorException> exceptionSupplier) throws ErrorException {
		if (isValid()) throw exceptionSupplier.get();
		return value;
	}

	@Override
	public <ErrorException extends Exception> T orElseThrow(@NotNull ErrorException exception) throws ErrorException {
		if (isValid()) throw exception;
		return value;
	}

	@Override
	public T orElse(@NotNull T other) {
		return isValid() ? other : value;
	}

	@Override
	public T orElseGet(@NotNull Supplier<T> supplier) {
		return isValid() ? supplier.get() : value;
	}

	@Override
	public void ifPresentOrElse(@NotNull Consumer<T> action, Runnable emptyAction) {
		Runnable runnableAction = () -> action.accept(value);
		(isValid() ? runnableAction : emptyAction).run();
	}

	@Override
	public T orElse(@NotNull Supplier<T> supplier) {
		return isValid() ? supplier.get() : value;
	}

	@Override
	public void ifPresent(@NotNull Consumer<T> action) {
		if (!isValid()) action.accept(value);
	}

	@Override
	public boolean equals(@NonNull Object o) {
		if (value == o) return true;
		return value.equals(o);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	public void ifEquals(Object o, @NotNull Consumer<T> action) {
		if (equals(o)) action.accept(value);
	}

	@Override
	public boolean isNull() {
		return Objects.isNull(value);
	}

	@Override
	public String toString() {
		return value.toString();
	}

	@Override
	public Class<T> getInternalClass() {
		@SuppressWarnings("unchecked")
		val clazz = (Class<T>) value.getClass();
		return clazz;
	}

	@Override
	public int compare(T other) {
		if (other == null) {
			return 1; // Non-null objects are considered greater than null
		}

		// Use the natural ordering of the encapsulated values for comparison
		if (value instanceof Comparable) {
			@SuppressWarnings("unchecked")
			Comparable<T> comparableValue = (Comparable<T>) value;
			return comparableValue.compareTo(other);
		}

		if (equals(other)) {
			return 1;
		}
		// If the encapsulated value is not comparable, you may want to provide a custom comparison logic
		// or throw an exception depending on your requirements.
		throw new UnsupportedOperationException("Comparison not supported for non-comparable types");
	}

	@Override
	public int compare(T o1, T o2) {
		return 0;
	}

	public Set<Field> fields() {
		return Arrays.stream(value.getClass().getDeclaredFields()).collect(Collectors.toUnmodifiableSet());
	}

	public boolean isAnnotationPresent(@NonNull Class<? extends Annotation> annotationClass) {
		return value.getClass().isAnnotationPresent(annotationClass);
	}

	public <A extends Annotation> A getAnnotation(@NonNull Class<A> annotationClass) {
		return value.getClass().getAnnotation(annotationClass);
	}
}
