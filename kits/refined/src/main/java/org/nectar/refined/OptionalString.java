package org.nectar.refined;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class OptionalString {

    private final String value;

    @Contract("_ -> new")
    public static @NotNull OptionalString of(@Nullable String value) {
        return new OptionalString(value);
    }

    public void ifPresent(Consumer<String> action) {
        Optional.ofNullable(value).ifPresent(s -> {
            if (!s.isBlank()) action.accept(s);
        });
    }

    public String orElse(String other) {
        return value != null && !value.isBlank() ? value : other;
    }

    public void ifPresentOrElse(Consumer<String> action, Runnable emptyAction) {
        if (value != null) {
            action.accept(value);
        } else {
            emptyAction.run();
        }
    }

    public boolean isEmpty() {
        return Objects.isNull(value) || value.isBlank();
    }


    public OptionalString filter(Predicate<String> predicate) {
        Objects.requireNonNull(predicate);
        if (isEmpty()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

//    public <U> Optional<U> map(Function<? super T, ? extends U> mapper) {
//        Objects.requireNonNull(mapper);
//        if (isEmpty()) {
//            return empty();
//        } else {
//            return Optional.ofNullable(mapper.apply(value));
//        }
//    }
//
//    public <U> Optional<U> flatMap(Function<OptionalString,U> mapper) {
//        Objects.requireNonNull(mapper);
//        if (isEmpty()) {
//            return empty();
//        } else {
//            @SuppressWarnings("unchecked")
//            Optional<U> r = (Optional<U>) mapper.apply(value);
//            return Objects.requireNonNull(r);
//        }
//    }

    public OptionalString or(Supplier<OptionalString> supplier) {
        Objects.requireNonNull(supplier);
        if (isEmpty()) {
            return this;
        } else {
            return Objects.requireNonNull(supplier.get());
        }
    }

    public Stream<String> stream() {
        if (isEmpty()) {
            return Stream.empty();
        } else {
            return Stream.of(value);
        }
    }

    @Contract(" -> new")
    public static @NotNull OptionalString empty() {
        return new OptionalString("");
    }
}
