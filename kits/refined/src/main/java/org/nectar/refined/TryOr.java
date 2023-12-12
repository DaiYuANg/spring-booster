/* (C)2023*/
package org.nectar.refined;

import jakarta.annotation.Nonnull;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.*;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Accessors(chain = true)
@ToString
public class TryOr<T, E extends Exception> {

	@Nullable @jakarta.annotation.Nullable @Getter
	private T result;

	@Setter(AccessLevel.PRIVATE)
	@Getter(AccessLevel.PRIVATE)
	private E e;

	private TryOr(@Nullable @jakarta.annotation.Nullable T result) {
		this.result = result;
	}

	@Nonnull
	public static <T, E extends Exception> @NotNull TryOr<T, E> attempt(Supplier<T> supplier) {
		try {
			T result = supplier.get();
			return new TryOr<>(result);
		} catch (Exception ex) {
			@SuppressWarnings("unchecked")
			val e = (E) ex;
			val tryOr = new TryOr<T, E>();
			tryOr.setE(e);
			return tryOr;
		}
	}

	public void ifError(Consumer<Exception> errorHandler) {
		if (e == null) return;
		errorHandler.accept(e);
	}

	public T orElse(T elseValue) {
		return elseValue;
	}

	@SuppressWarnings("LexicographicalAnnotationListing")
	@SneakyThrows
	public <U> @NotNull TryOr<U, E> map(@NotNull Function<T, U> mapper) {
		if (e != null) throw e.getCause();
		return new TryOr<>(mapper.apply(result));
	}

	@SneakyThrows
	@SuppressWarnings({"LexicographicalAnnotationListing", "RequireNonNullWithMessageStatement"})
	public <U> TryOr<U, E> flatMap(@NonNull @NotNull Function<T, TryOr<U, E>> mapper) {
		if (e != null) throw e.getCause();
		return mapper.apply(result);
	}

	@NotNull public Optional<T> resultToOptional() {
		return Optional.ofNullable(result);
	}

	@NotNull public Optional<E> exceptionToOptional() {
		return Optional.ofNullable(e);
	}
}
