package org.kop.libs.io.base.define;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CommonPath {
    TEMPORARY_DIR(System.getProperty("java.io.tmp"));

    @Getter
    private final String value;
}
