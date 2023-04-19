package org.daiyuang.thready.pool;

import lombok.Builder;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Log
public class PoolCreator implements ICreator{
    public ThreadPoolExecutor cpuCoreDefault() {
        log.info("123");
        return null;
    }

    @Override
    public ThreadPoolExecutor creator() {
        return null;
    }
}
