package org.kop.examples.frameworks.spring.curd.example.dict;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.kop.framework.spring.boot.starter.dict.annotation.DictMetadata;
import org.kop.framework.spring.boot.starter.dict.store.BindDict;

@ToString
@Getter
@DictMetadata(code = "test")
@AllArgsConstructor
public enum TestDict implements BindDict {
    TEST("k", "2", "3"),
    //    @DictDefine(code = "test")
    TEST_STORE("k2", "1", "3");

    private final String dictName;

    private final String dictCode;

    private final String dictText;

    @Override
    public String dictName() {
        return dictName;
    }

    @Override
    public String dictCode() {
        return dictCode;
    }

    @Override
    public String dictText() {
        return dictText;
    }
}
