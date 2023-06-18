package org.kop.apps.docky.core;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

@Slf4j
public class DockyConfig {
    public DockyConfig(){
        Config c = ConfigProvider.getConfig();
    }
}
