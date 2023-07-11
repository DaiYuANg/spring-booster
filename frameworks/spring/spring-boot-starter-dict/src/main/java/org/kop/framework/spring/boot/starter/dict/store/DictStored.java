package org.kop.framework.spring.boot.starter.dict.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.kop.framework.spring.boot.starter.dict.store.obj.Dict;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class DictStored {

    @Resource
    private DictScanner dictScanner;

    private ConcurrentMap<String, AtomicInteger> hit = new ConcurrentSkipListMap<>();

    @PostConstruct
    public void init() {
        System.err.println(dictScanner.cache);
    }

    public Dict text(String dict) {
        return dictScanner.cache.get(dict);
    }
}
