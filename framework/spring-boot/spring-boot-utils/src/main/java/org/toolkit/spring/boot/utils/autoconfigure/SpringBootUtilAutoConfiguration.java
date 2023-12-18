/* (C)2023*/
package org.toolkit.spring.boot.utils.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@Slf4j
@ComponentScan("org.toolkit.spring.boot.utils.**.*")
public class SpringBootUtilAutoConfiguration {}
