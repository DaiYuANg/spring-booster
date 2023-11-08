package org.toolkit.cli.factory;

import com.google.inject.ConfigurationException;
import org.toolkit.cli.di.DIContainer;
import picocli.CommandLine;

public class GuiceFactory implements CommandLine.IFactory {
    @Override
    public <K> K create(Class<K> cls) throws Exception {
        try {
            return DIContainer.INSTANCE.getInjector().getInstance(cls);
        } catch (ConfigurationException ex) {
            return CommandLine.defaultFactory().create(cls);
        }
    }
}
