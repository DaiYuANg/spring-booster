/* (C)2023*/
package org.nectar.refined.container;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lombok.EqualsAndHashCode;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.nectar.refined.exception.EmptyCollection;

@EqualsAndHashCode(callSuper = true)
public class CollectionContainer<E> extends BasicContainer<Collection<E>, CollectionContainer<E>> {
	protected CollectionContainer(Collection<E> value) {
		super(value);
	}

	@Override
	public CollectionContainer<E> filter(Predicate<Collection<E>> predicate) {
		return isEmpty() ? this : predicate.test(value) ? this : empty();
	}

	@Override
	public <U extends Container<Collection<E>, ?>> CollectionContainer<E> map(
			Function<? super Collection<E>, U> mapper) {
		if (isEmpty()) {
			return empty();
		} else {
			@SuppressWarnings("unchecked")
			val result = (CollectionContainer<E>) mapper.apply(value);
			return result;
		}
	}

	@Override
	public <U> CollectionContainer<E> flatMap(
			Function<? super Collection<E>, ? extends Container<Collection<E>, ? extends U>> mapper) {
		return isEmpty()
				? empty()
				: new CollectionContainer<>(mapper.apply(value).get());
	}

	@Override
	public CollectionContainer<E> or(Supplier<CollectionContainer<E>> supplier) {
		return isEmpty() ? supplier.get() : this;
	}

	@Contract("_ -> new")
	@NotNull public static <E> CollectionContainer<E> of(@Nullable Collection<E> value) {
		return new CollectionContainer<>(value);
	}

	public Stream<E> elementStream() {
		return Objects.requireNonNull(value).stream();
	}

	public Stream<E> elementParallelStream() {
		return Objects.requireNonNull(value).parallelStream();
	}

	@NotNull @Contract(" -> new")
	public static <E> CollectionContainer<E> empty() {
		return new CollectionContainer<>(null);
	}

	@Override
	public Collection<E> orElseThrow() {
		throw new EmptyCollection();
	}

	//
	@Override
	public Collection<E> get() {
		return orElseThrow((Supplier<EmptyCollection>) EmptyCollection::new);
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty() || value.isEmpty();
	}
}
