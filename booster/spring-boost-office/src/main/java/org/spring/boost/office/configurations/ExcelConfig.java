/* (C)2024*/
package org.spring.boost.office.configurations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.compress.archivers.zip.Zip64Mode;

@ToString
@Accessors(chain = true)
@Getter
@Setter
public class ExcelConfig {
    private Integer SXSSFSlidingWindow = 100;

    private Boolean SXSSFCompression = true;

    private Zip64Mode SXSSFZipMode = Zip64Mode.AsNeeded;
}
