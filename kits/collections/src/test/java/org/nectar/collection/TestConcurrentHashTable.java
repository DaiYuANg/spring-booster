/* (C)2023*/
package org.nectar.collection;

import org.junit.jupiter.api.Test;

public class TestConcurrentHashTable {

	private ConcurrentHashTable<String, Integer, Integer> concurrentHashTable = new ConcurrentHashTable<>();

	@Test
	void testPut() {
		concurrentHashTable.put("test", 1, 2);
	}
}
