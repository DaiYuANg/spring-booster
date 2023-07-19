package org.toolkit4j.libs.helpers

import com.cronutils.builder.CronBuilder
import com.cronutils.model.Cron
import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.model.field.expression.FieldExpression.always
import com.cronutils.model.field.expression.FieldExpression.questionMark
import com.cronutils.model.field.expression.FieldExpressionFactory.between
import com.cronutils.model.field.expression.FieldExpressionFactory.on
import com.cronutils.model.field.value.SpecialChar
import com.cronutils.parser.CronParser
import java.math.BigDecimal
import java.math.RoundingMode


fun isZero(b1: BigDecimal): Boolean {
  return eq(b1, BigDecimal.ZERO)
}

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

fun divideHalfUp(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.HALF_UP)
}

fun divideHalfDown(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.HALF_DOWN)
}

fun divideDown(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.DOWN)
}

fun divideFloor(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.FLOOR)
}

fun divideCeiling(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.CEILING)
}

fun divideHalfEven(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.HALF_EVEN)
}

fun divideUp(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.UP)
}

fun divideUnnecessary(divisor: BigDecimal, dividend: BigDecimal): BigDecimal {
  return dividend.divide(divisor, RoundingMode.UNNECESSARY)
}