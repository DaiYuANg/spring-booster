package org.toolkit.spring.boot.utils.bean

import lombok.extern.slf4j.Slf4j
import org.jetbrains.annotations.Contract
import org.jetbrains.annotations.NotNull
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.context.ApplicationContext
import org.springframework.core.ResolvableType
import org.springframework.stereotype.Component
import java.util.*

@Component
@Slf4j
class BeanUtil(private val context: ApplicationContext, private val beanFactory: DefaultListableBeanFactory) {
    fun <T> findBeans(clazz: Class<T>): List<T> {
        return context.getBeansOfType(clazz).values.stream().toList()
    }

    @Contract("_, _, _ -> new")
    fun <T> getBeansWithAnnotationAndGenericType(
        clazz: Class<*>?, annotation: Class<out Annotation?>?, vararg genericTypes: Class<*>?
    ): Map<String, T> {
        val type = clazz?.let { ResolvableType.forClassWithGenerics(it, *genericTypes) }
        annotation?.let { context.getBeansWithAnnotation(it) }
        return HashMap()
    }

    @SafeVarargs
    fun <T> getBeansWithGenericType(clazz: Class<T>?, vararg genericTypes: Class<T>?): Optional<T> {
        val type = clazz?.let { ResolvableType.forClassWithGenerics(it, *genericTypes) }
        return Optional.ofNullable<T & Any>(type?.let { context.getBeanProvider<T>(it).getIfAvailable() })
    }

    fun <T> getBeansOfType(tClass: Class<T>): List<T> {
        return context.getBeansOfType(tClass).values.stream().toList()
    }

    fun <T> putAllAsSingleton(@NotNull beans: Map<String?, T>) {
        beans.forEach { (key, value) ->
            key?.let { beanFactory.registerSingleton(it, value!!) }
        }
    }
}
