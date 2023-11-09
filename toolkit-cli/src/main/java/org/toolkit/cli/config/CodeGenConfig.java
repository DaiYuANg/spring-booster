package org.toolkit.cli.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.github.gestalt.config.annotations.Config;
import org.github.gestalt.config.annotations.ConfigPrefix;

@Getter
@Setter
@ToString
public class CodeGenConfig {


    @Config(path = "package")
    String packageName;
}
