package org.daiyuang.thready.pool;

import java.util.concurrent.ThreadPoolExecutor;

public interface ICreator {
    int CPU_COUNT = Runtime.getRuntime().availableProcessors();

    int CORE_POOL_SIZE = CPU_COUNT + 1;

    int MAX_POOL_SIZE = CPU_COUNT * 4;

    int QUEUE_CAPACITY = 100;

    long KEEP_ALIVE_TIME = 60L;

    ThreadPoolExecutor creator();
}
