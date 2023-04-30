package org.kop.libs.collections.lists;

import org.kop.libs.collections.defintion.OptionalCollections;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class OptionalList<E> extends ArrayList<E> implements OptionalCollections<E> {
    public Optional<E> getOptional(int index) {
        try {
            return Optional.ofNullable(super.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<E> optionalGet(Object object) {
        try {
            return super.stream().filter(e -> Objects.equals(e, object)).findAny();
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }
}
