/* (C)2024*/
package org.spring.boost.core.api;

/**
 * Rewrite the wrapper of spring configuration entry point
 * @param <T> Is spring boot configuration object
 */
public interface FeatureInstaller<T> {

    void install(T t);
}
