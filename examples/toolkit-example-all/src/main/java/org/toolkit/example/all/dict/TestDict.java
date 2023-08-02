package org.toolkit.example.all.dict;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
// @DictMetadata(code = "test")
@RequiredArgsConstructor
public class TestDict {
//    @DictValue(code = "test", text = "测试")
    private String ty;

    //	@DictValue(code = "test_store", text = "测试 存储")
//    TEST_STORE("k2");

//	public final String value;
}
