package org.toolkit4J.libs.helpers.math;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    public static boolean lt(@NotNull BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) < 0;
    }

    public static boolean le(@NotNull BigDecimal b1, BigDecimal b2) {
        return b1.compareTo(b2) <= 0;
    }

    @Contract(pure = true)
    public static @NotNull BigDecimal divideHalfUp(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.HALF_UP);
    }

    public static @NotNull BigDecimal divideHalfDown(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.HALF_DOWN);
    }

    public static @NotNull BigDecimal divideDown(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.DOWN);
    }

    public static @NotNull BigDecimal divideFloor(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.FLOOR);
    }

    public static @NotNull BigDecimal divideCeiling(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.CEILING);
    }

    public static @NotNull BigDecimal divideHalfEven(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.HALF_EVEN);
    }

    public static @NotNull BigDecimal divideUp(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.UP);
    }

    public static @NotNull BigDecimal divideUnnecessary(@NotNull BigDecimal divisor, @NotNull BigDecimal dividend) {
        return dividend.divide(divisor, RoundingMode.UNNECESSARY);
    }
}
