/* (C)2024*/
package org.spring.boost.core.api;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author daiyuang
 */
public interface BeanRegistry {

  /**
   * Finds beans by a specified annotation and bean type, returning a map with keys as annotation instances and values as corresponding beans.
   * <p>
   * 根据指定的注解和 bean 类型查找 bean，返回一个 map，其中键为注解实例，值为对应的 bean。
   *
   * @param annotation Annotation The annotation class to search for.
   *                   注解类，用于查找具有该注解的 bean。
   * @param beanType   beanType The type of the beans to search for.
   *                   要查找的 bean 类型。
   * @param <A>        The type of the annotation.
   *                   注解的类型。
   * @param <T>        The type of the beans.
   *                   bean 的类型。
   * @return A map with keys as annotation instances and values as corresponding beans.
   *         返回一个 map，其中键为注解实例，值为对应的 bean。
   */
  <A extends Annotation, T> Map<A, T> getBeanWithAnnotationMap(Class<A> annotation, Class<T> beanType);

  /**
   * Finds beans by a specified annotation and bean type, returning a collection of matching beans.
   * <p>
   * 根据指定的注解和 bean 类型查找 bean，返回一个匹配的 bean 集合。
   *
   * @param annotation Annotation The annotation class to search for.
   *                   注解类，用于查找具有该注解的 bean。
   * @param beanType   beanType The type of the beans to search for.
   *                   要查找的 bean 类型。
   * @param <T>        The type of the beans.
   *                   bean 的类型。
   * @return A collection of matching beans.
   *         返回匹配的 bean 集合。
   */
  <T> Collection<T> getBeanWithAnnotation(Class<? extends Annotation> annotation, Class<T> beanType);

  /**
   * Finds beans by a specified annotation and bean type, returning an immutable collection of matching beans.
   * <p>
   * 根据指定的注解和 bean 类型查找 bean，返回一个不可变的匹配 bean 集合。
   *
   * @param annotation Annotation The annotation class to search for.
   *                   注解类，用于查找具有该注解的 bean。
   * @param beanType   beanType The type of the beans to search for.
   *                   要查找的 bean 类型。
   * @param <T>        The type of the beans.
   *                   bean 的类型。
   * @return An immutable collection of matching beans.
   *         返回一个不可变的匹配 bean 集合。
   */
  <T> Collection<T> getBeanWithAnnotationImmutable(Class<? extends Annotation> annotation, Class<T> beanType);

  /**
   * Returns distinct beans of the specified type.
   * <p>
   * 返回指定类型的去重 bean。
   *
   * @param beanTypeClass The type of beans to retrieve.
   *                      要检索的 bean 类型。
   * @param <T>           The type of the beans.
   *                      bean 的类型。
   * @return A set of distinct beans.
   *         返回去重后的 bean 集合。
   */
  <T> Set<T> getBeanDistinct(Class<T> beanTypeClass);

  /**
   * Returns an immutable map of beans of the specified type, where the keys are bean names and the values are the beans.
   * <p>
   * 返回指定类型的不可变 bean map，其中键为 bean 名称，值为对应的 bean 实例。
   *
   * @param beanType The type of beans to retrieve.
   *                 要检索的 bean 类型。
   * @param <T>      The type of the beans.
   *                 bean 的类型。
   * @return An immutable map of beans.
   *         返回一个不可变的 bean map。
   */
  <T> ImmutableMap<String, T> getBeanOfTypeImmutable(Class<T> beanType);

  /**
   * Finds beans by a specified annotation and bean type, returning a stream of matching beans.
   * <p>
   * 根据指定的注解和 bean 类型查找 bean，返回一个匹配 bean 的流。
   *
   * @param annotation Annotation The annotation class to search for.
   *                   注解类，用于查找具有该注解的 bean。
   * @param beanType   beanType The type of the beans to search for.
   *                   要查找的 bean 类型。
   * @param <T>        The type of the beans.
   *                   bean 的类型。
   * @return A stream of matching beans.
   *         返回匹配 bean 的流。
   */
  <T> Stream<T> findByAnnotation(Class<? extends Annotation> annotation, Class<T> beanType);

  /**
   * Registers a bean with the specified name.
   * <p>
   * 注册一个具有指定名称的 bean。
   *
   * @param name The name of the bean.
   *             bean 的名称。
   * @param bean The bean instance to register.
   *             要注册的 bean 实例。
   * @param <T>  The type of the bean.
   *             bean 的类型。
   */
  <T> void register(String name, T bean);

  /**
   * Registers all the provided beans.
   * <p>
   * 注册所有提供的 bean。
   *
   * @param beans A map of bean names to bean instances.
   *              一个包含 bean 名称和实例的 map。
   * @param <T>   The type of the beans.
   *              bean 的类型。
   */
  <T> void registerAll(@NotNull Map<String, T> beans);

  /**
   * Returns a set of possible classpaths that the application can scan for beans.
   * <p>
   * 返回应用程序可以扫描的可能的类路径集合。
   *
   * @return A set of classpath strings.
   *         返回一个类路径字符串集合。
   */
  Set<String> possibleClasspath();

  /**
   * Retrieves a bean by its class type.
   * <p>
   * 根据其类类型检索一个 bean。
   *
   * @param clazz The class type of the bean.
   *              bean 的类类型。
   * @param <T>   The type of the bean.
   *              bean 的类型。
   * @return The bean instance.
   *         返回 bean 实例。
   */
  <T> T get(Class<T> clazz);
}
