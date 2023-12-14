/* (C)2023*/
package org.nectar.refined;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
class Either<L, R> {
	private final L left;
	private final R right;
	private final boolean isLeft;

	@Contract("_ -> new")
	public static <L, R> @NotNull Either<L, R> left(@NonNull L value) {
		return new Either<>(value, null, true);
	}

	@Contract("_ -> new")
	public static <L, R> @NotNull Either<L, R> right(@NonNull R value) {
		Objects.requireNonNull(value);
		return new Either<>(null, value, false);
	}

	public static <L, R> Either<L, R> of(R value, @NotNull Predicate<R> condition, L leftValue) {
		return condition.test(value) ? right(value) : left(leftValue);
	}

	public static <L, R> Either<L, R> of(R value, @NotNull Predicate<R> condition, Function<R, L> leftSupplier) {
		return condition.test(value) ? right(value) : left(leftSupplier.apply(value));
	}

	public boolean isLeft() {
		return isLeft;
	}

	public L getLeft() {
		if (!isLeft) {
			throw new IllegalStateException("Either.getRight() called on a Right");
		}
		return left;
	}

	public R getRight() {
		if (isLeft) {
			throw new IllegalStateException("Either.getLeft() called on a Left");
		}
		return right;
	}
}