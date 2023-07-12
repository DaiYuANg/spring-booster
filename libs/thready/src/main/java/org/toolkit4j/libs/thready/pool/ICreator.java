package org.toolkit4j.libs.thready.pool;

import java.util.concurrent.ThreadPoolExecutor;

public interface ICreator {
    ThreadPoolExecutor creator();
}
