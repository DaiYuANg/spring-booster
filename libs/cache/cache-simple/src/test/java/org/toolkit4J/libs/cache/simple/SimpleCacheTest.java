package org.toolkit4J.libs.cache.simple;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCacheTest {
    SimpleCache<String, Integer> simpleCache = new SimpleCache<>();

    @BeforeEach
    void setUp() {
        IntStream.range(0,3000).parallel().forEachOrdered(i-> simpleCache.put("k"+ i,i));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void forEach() {
//        simpleCache.forEach(stringIntegerEntry -> {
//            System.err.println(stringIntegerEntry);
//        });
    }

    @Test
    void spliterator() {
    }

    @SneakyThrows
    @Test
    void put() {
        simpleCache.put("test",321,1, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(2);

        System.err.println(simpleCache);
    }

    @Test
    void testPut() {
    }

    @Test
    void testPut1() {
    }

    @Test
    void putIfAbsent() {
    }

    @Test
    void getOrPut() {
    }

    @Test
    void getAndRemove() {
    }

    @Test
    void hasKey() {
    }

    @Test
    void hasValue() {
    }

    @Test
    void get() {
    }

    @Test
    void getAllOfKey() {
    }

    @Test
    void getAllOfValue() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void testRemoveAll() {
    }

    @Test
    void testRemoveAll1() {
    }

    @Test
    void clear() {
    }

    @Test
    void removeAndGet() {
    }

    @Test
    void expire() {
    }

    @Test
    void testExpire() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void iterator() {
    }
}