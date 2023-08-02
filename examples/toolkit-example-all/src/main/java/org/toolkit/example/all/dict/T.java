package org.toolkit.example.all.dict;

import org.toolkit.spring.boot.starter.dict.annotations.Dict;
import org.toolkit.spring.boot.starter.dict.annotations.DictValue;

@Dict
public class T {

    @DictValue(code = "test", text = "测试")
    private String TT;
}
