package org.kop.libs.helpers.math

import org.jetbrains.annotations.Contract
import java.math.BigDecimal
import java.math.RoundingMode

@Contract(pure = true)
fun eq(b1: BigDecimal, b2: BigDecimal): Boolean {
    return b1.compareTo(b2) == 0
}

fun gt(b1: BigDecimal, b2: BigDecimal): Boolean {
    return b1 > b2
}

fun ge(b1: BigDecimal, b2: BigDecimal): Boolean {
    return b1.compareTo(b2) >= 1
}

fun lt(b1: BigDecimal, b2: BigDecimal): Boolean {
    return b1 < b2
}

fun le(b1: BigDecimal, b2: BigDecimal): Boolean {
    return b1 <= b2
}

@Contract(pure = true)
fun divideHalfUp(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.HALF_UP)
}

@Contract(pure = true)
fun divideHalfDown(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.HALF_DOWN)
}

@Contract(pure = true)
fun divideDown(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.DOWN)
}

@Contract(pure = true)
fun divideFloor(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.FLOOR)
}

@Contract(pure = true)
fun divideCeiling(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.CEILING)
}

@Contract(pure = true)
fun divideHalfEven(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.HALF_EVEN)
}

@Contract(pure = true)
fun divideUp(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.UP)
}

@Contract(pure = true)
fun divideUnnecessary(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
    return dividend.divide(divisor, RoundingMode.UNNECESSARY)
}