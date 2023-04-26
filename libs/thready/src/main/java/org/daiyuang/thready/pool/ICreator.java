package org.daiyuang.thready.pool;

import java.util.concurrent.ThreadPoolExecutor;

public interface ICreator {
    ThreadPoolExecutor creator();
}
