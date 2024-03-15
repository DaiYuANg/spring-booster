/* (C)2024*/
package org.spring.boost.core.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClassScannerConfig {
    private Boolean enableClassGraphLog = false;

    private Boolean verbose = false;
}
