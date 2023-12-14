/* (C)2023*/
package org.nectar.refined.container;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.nectar.refined.base.Streamable;
import org.nectar.refined.exception.MethodNotImplemented;

public interface Container<Type, Implement extends Container<Type, Implement>> extends Streamable<Type> {
	void ifPresent(Consumer<Type> action);

	Type orElse(Type other);

	Type orElseGet(Supplier<Type> supplier);

	void ifPresentOrElse(Consumer<Type> action, Runnable emptyAction);

	boolean isEmpty();

	Implement filter(Predicate<Type> predicate);

	<U extends Container<Type, ?>> Implement map(Function<? super Type, U> mapper);

	default <U> Implement flatMap(Function<? super Type, ? extends Container<Type, ? extends U>> mapper) {
		throw new MethodNotImplemented();
	}

	Type orElse(Supplier<Type> supplier);

	Type orElseThrow();

	Type get();

	Implement or(Supplier<Implement> supplier);

	<ErrorException extends Exception> Type orElseThrow(Class<ErrorException> exceptionClass);

	<ErrorException extends Exception> Type orElseThrow(Supplier<? extends ErrorException> exceptionSupplier)
			throws ErrorException;

	<ErrorException extends Exception> Type orElseThrow(ErrorException exception) throws ErrorException;

	Optional<Type> toOptional();

	CompletableFuture<Type> toCompletableFuture();
}
