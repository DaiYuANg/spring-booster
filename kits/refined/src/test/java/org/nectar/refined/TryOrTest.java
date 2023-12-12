/* (C)2023*/
package org.nectar.refined;

import org.junit.jupiter.api.Test;

final class TryOrTest {

	@Test
	void attempt() {
		TryOr.attempt(() -> {
					throw new NullPointerException();
				})
				.ifError(err -> {
					System.err.println(err);
				});
		//		val tryOr = TryOr.<Integer>attempt(() -> {
		//					throw new NullPointerException();
		//				})
		//				.orElse(1);
		//		assertEquals(1, tryOr);
	}

	@Test
	void ifError() {}

	@Test
	void orElse() {}

	@Test
	void getResult() {}

	@Test
	void getE() {}

	@Test
	void setE() {}
}
