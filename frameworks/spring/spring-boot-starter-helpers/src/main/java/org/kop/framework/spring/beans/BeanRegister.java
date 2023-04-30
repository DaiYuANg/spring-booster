package org.kop.framework.spring.beans;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.libs.thready.async.AsyncWorker;
import org.daiyuang.libs.thready.pool.PoolCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@Slf4j
public class BeanRegister {

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Bean
    @Order(0)
    protected ThreadPoolExecutor threadPoolExecutor() {
        return new PoolCreator().creator();
    }

    @Bean
    public AsyncWorker asyncWorker() {
        return AsyncWorker.builder().executor(threadPoolExecutor).build();
    }
}
