package org.toolkit.cli.factory;

import com.google.inject.ConfigurationException;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.cli.module.DIContainer;
import picocli.CommandLine;

@Slf4j
public class GuiceFactory implements CommandLine.IFactory {
    @Override
    public <K> K create(Class<K> cls) throws Exception {
        try {
            return DIContainer.INSTANCE.getInjector().getInstance(cls);
        } catch (ConfigurationException ex) { // no implementation found in Guice configuration
            return CommandLine.defaultFactory().create(cls); // fallback if missing
        }
    }
}
