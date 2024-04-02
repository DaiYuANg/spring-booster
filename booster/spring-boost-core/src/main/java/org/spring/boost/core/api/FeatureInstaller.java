/* (C)2024*/
package org.spring.boost.core.api;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * Rewrite the wrapper of spring configuration entry point
 *
 * @param <T> Is spring boot configuration object
 */
public interface FeatureInstaller<T> {

  void install(ConfigurableApplicationContext context, T t);
}
