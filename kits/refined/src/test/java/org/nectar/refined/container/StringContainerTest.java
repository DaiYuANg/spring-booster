/* (C)2023*/
package org.nectar.refined.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class StringContainerTest {

	private final StringContainer sc = spy(StringContainer.of("test"));

	@Test
	void ifPresent() {
		sc.ifPresent(value -> System.out.println("ifPresent function executed!"));
		verify(sc, times(1)).ifPresent(any());
	}

	@Test
	void orElse() {
		assertEquals(sc.orElse("test1"), "test");
	}

	@Test
	void isEmpty() {
		assertFalse(sc.isEmpty());
	}

	@Test
	void filter() {}

	@Test
	void map() {}

	@Test
	void flatMap() {}

	@Test
	void testOrElse() {}

	@Test
	void empty() {}

	@Test
	void orElseThrow() {}

	@Test
	void get() {}

	@Test
	void or() {}

	@Test
	void testOrElseThrow() {}

	@Test
	void testOrElseThrow1() {}

	@Test
	void testOrElseThrow2() {}

	@Test
	void of() {
		assertNotNull(sc);
	}
}
