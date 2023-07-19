package org.toolkit4j.libs.thready.async;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

@Slf4j
class AsyncWorkerTest {

    @Test
    void run() {
        val as = AsyncWorker.builder().build();
        as.parallelALL(
                        () -> log.info("test"),
                        ()->log.info("test1")
                )
                .join();
    }
}