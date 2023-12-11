package org.toolkit.spring.boot.utils.autoconfigure;

import cn.hutool.extra.spring.EnableSpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@AutoConfiguration
@Slf4j
@EnableSpringUtil
@ComponentScan("org.toolkit.spring.boot.utils.**.*")
public class SpringBootUtilAutoConfiguration {}
