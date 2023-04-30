package org.kop.libs.collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kop.libs.collections.lists.OptionalList;

import java.util.Optional;
import java.util.stream.IntStream;

class OptionalListTest {

    OptionalList<Integer> optionalList = new OptionalList<>();

    int max = 999999;

    @BeforeEach
    public void init() {
        IntStream.range(0, max).forEach(i -> optionalList.add(i));
    }

    @AfterEach
    public void clear() {
        optionalList.clear();
    }

    @Test
    public void testThrow() {
        Assertions.assertThrows(
                RuntimeException.class,
                () -> optionalList.optionalGet(max + 1)
                        .orElseThrow(RuntimeException::new));
    }

    @Test
    public void testOutIndex(){
        Assertions.assertEquals(optionalList.optionalGet(50), Optional.of(50));
    }
}