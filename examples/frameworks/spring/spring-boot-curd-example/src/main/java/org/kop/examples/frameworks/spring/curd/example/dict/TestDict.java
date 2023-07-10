package org.kop.examples.frameworks.spring.curd.example.dict;


import lombok.Getter;
import lombok.ToString;
import org.kop.framework.spring.boot.starter.dict.annotation.DictDefine;

@ToString
@Getter
@DictDefine
public enum TestDict{
    TEST("k", 2, 3),
//    @DictDefine(code = "test")
    TEST_STORE("k2", 1, 3);
    private String k2;

    TestDict(String k2, int i, int i1) {
        this.k2 = k2;
    }
}
