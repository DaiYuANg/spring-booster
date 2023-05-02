package org.kop.libs.collections.lists;

import com.google.common.base.Stopwatch;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalList<E> extends ArrayList<E> implements IOptionalList<E> {

    /**
     * catch IndexOutOfBoundsException and return optional object
     *
     * @param index list index
     * @return optional object
     */
    @Override
    public Optional<E> optionalGet(int index) {
        try {
            return Optional.ofNullable(super.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    /**
     * @param object object in list
     * @return optional object
     */
    @Override
    public Optional<E> optionalGet(E object) {
        return super.stream().filter(e -> Objects.equals(e, object)).findAny();
    }
}
