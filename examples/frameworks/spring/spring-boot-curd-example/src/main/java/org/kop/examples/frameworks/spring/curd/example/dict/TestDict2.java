package org.kop.examples.frameworks.spring.curd.example.dict;


import lombok.Getter;
import org.kop.framework.spring.boot.starter.dict.store.BindDict;

@Getter
public enum TestDict2 implements BindDict {
    TEST,
    TEST_STORE;

    @Override
    public String dictName() {
        return null;
    }

    @Override
    public String dictCode() {
        return null;
    }

    @Override
    public String dictText() {
        return null;
    }
}
