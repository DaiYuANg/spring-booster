package org.toolkit4J.libs.helpers.math;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

@UtilityClass
public class BigDecimalHelper {
    @Contract(pure = true)
    public static boolean isZero(BigDecimal b1) {
        return eq(b1, BigDecimal.ZERO);
    }

    @Contract(pure = true)
    public static boolean eq(@NotNull BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) == 0;
    }

    @Contract(pure = true)
    public static boolean gt(@NotNull BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) > 0;
    }

    public static boolean ge(@NotNull BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) >= 1;
    }
//
//    fun ge(b1: BigDecimal, b2: BigDecimal): Boolean {
//        return b1.compareTo(b2) >= 1
//    }
//
//    fun lt(b1: BigDecimal, b2: BigDecimal): Boolean {
//        return b1 < b2
//    }
//
//    fun le(b1: BigDecimal, b2: BigDecimal): Boolean {
//        return b1 <= b2
//    }
//
//    fun divideHalfUp(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.HALF_UP)
//    }
//
//    fun divideHalfDown(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.HALF_DOWN)
//    }
//
//    fun divideDown(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.DOWN)
//    }
//
//    fun divideFloor(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.FLOOR)
//    }
//
//    fun divideCeiling(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.CEILING)
//    }
//
//    fun divideHalfEven(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.HALF_EVEN)
//    }
//
//    fun divideUp(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.UP)
//    }
//
//    fun divideUnnecessary(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
//        return dividend.divide(divisor, RoundingMode.UNNECESSARY)
//    }
}
