package org.daiyuang.utils.math;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@UtilityClass
@Experimental
@Slf4j
public class RandomUtil {
    public static <T extends Number> T randomNumber(T o) {
        return (T) Integer.valueOf(new Random().nextInt());
//        return RandomGeneratorFactory.all().sorted(Comparator.comparing(RandomGeneratorFactory::name))
//                .forEach(factory -> System.out.printf("%s\t%s\t%s\t%s%n",
//                        factory.group(),
//                        factory.name(),
//                        factory.isJumpable(),
//                        factory.isSplittable()));
    }
}
