/* (C)2023*/
package org.nectar.refined;

import static org.junit.jupiter.api.Assertions.*;

import lombok.val;
import org.junit.jupiter.api.Test;

class EitherTest {

	@Test
	void left() {
		val e = Either.of(1, left -> left > 10, 2);
		System.err.println(e.getLeft());
	}

	@Test
	void right() {}

	@Test
	void of() {}

	@Test
	void testOf() {}

	@Test
	void isLeft() {}

	@Test
	void getLeft() {}

	@Test
	void getRight() {}
}
