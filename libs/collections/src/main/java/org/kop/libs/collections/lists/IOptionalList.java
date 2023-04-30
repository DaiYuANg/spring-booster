package org.kop.libs.collections.lists;

import java.util.Optional;

public interface IOptionalList<E> {
    Optional<E> optionalGet(E e);

    Optional<E> optionalGet(int index);
}
