package org.kop.libs.collections;

import org.junit.jupiter.api.Test;
import org.kop.libs.collections.lists.OptionalList;

class OptionalMapTest {

    @Test
    public void te() {
        var t = new OptionalList<Integer>() {{
            add(1);
            add(2);
        }};
        t.getOptional(3).orElseThrow(RuntimeException::new);
    }
}