package org.kop.examples.frameworks.spring.curd.example.dict;


import lombok.Getter;
import org.kop.framework.spring.boot.starter.dict.annotation.DictDefine;

@Getter
public enum TestDict2 {
    @DictDefine
    TEST,
    TEST_STORE
}
