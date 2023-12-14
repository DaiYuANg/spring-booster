/* (C)2023*/
package org.nectar.refined.container;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.NonNull;
import org.nectar.refined.base.Streamable;
import org.nectar.refined.exception.MethodNotImplemented;

public interface Container<Type, Implement extends Container<Type, Implement>>
		extends Streamable<Type>, Serializable, Comparator<Type> {

	void ifPresent(@NonNull Consumer<Type> action);

	Type orElse(@NonNull Type other);

	Type orElseGet(@NonNull Supplier<Type> supplier);

	void ifPresentOrElse(@NonNull Consumer<Type> action, Runnable emptyAction);

	boolean isValid();

	Implement filter(@NonNull Predicate<Type> predicate);

	<U extends Container<Type, ?>> Implement map(@NonNull Function<? super Type, U> mapper);

	default <U> Implement flatMap(@NonNull Function<? super Type, ? extends Container<Type, ? extends U>> mapper) {
		throw new MethodNotImplemented();
	}

	Type orElse(@NonNull Supplier<Type> supplier);

	Type orElseThrow();

	Type get();

	Implement or(@NonNull Supplier<Implement> supplier);

	<ErrorException extends Exception> Type orElseThrow(@NonNull Class<ErrorException> exceptionClass);

	<ErrorException extends Exception> Type orElseThrow(@NonNull Supplier<? extends ErrorException> exceptionSupplier)
			throws ErrorException;

	<ErrorException extends Exception> Type orElseThrow(@NonNull ErrorException exception) throws ErrorException;

	Optional<Type> toOptional();

	CompletableFuture<Type> toCompletableFuture();

	void ifEquals(Object o, @NonNull Consumer<Type> action);

	boolean isNull();

	Class<Type> getInternalClass();

	int compare(Type other);
}
