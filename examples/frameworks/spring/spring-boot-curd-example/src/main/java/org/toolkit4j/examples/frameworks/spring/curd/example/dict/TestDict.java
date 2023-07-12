package org.toolkit4j.examples.frameworks.spring.curd.example.dict;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.toolkit4j.framework.spring.boot.starter.dict.annotation.DictMetadata;
import org.toolkit4j.framework.spring.boot.starter.dict.annotation.DictValue;

@ToString
@Getter
@DictMetadata(code = "test")
@RequiredArgsConstructor
public enum TestDict {
    @DictValue(code = "test", text = "测试")
    TEST("k"),

    @DictValue(code = "test_store", text = "测试 存储")
    TEST_STORE("k2");

    public final String value;
}
