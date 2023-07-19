package org.toolkit4j.libs.helpers.math

import com.cronutils.builder.CronBuilder
import com.cronutils.model.Cron
import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.model.field.expression.FieldExpression.always
import com.cronutils.model.field.expression.FieldExpression.questionMark
import com.cronutils.model.field.expression.FieldExpressionFactory.between
import com.cronutils.model.field.expression.FieldExpressionFactory.on
import com.cronutils.model.field.value.SpecialChar
import com.cronutils.model.time.ExecutionTime
import com.cronutils.parser.CronParser
import io.netty.resolver.HostsFileEntriesProvider.parser
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.ZonedDateTime
import java.util.*


class BigDecimalHelperKtTest {

  @Test
  fun gt() {
    kotlin.test.assertTrue { (org.toolkit4j.libs.helpers.gt(BigDecimal.TEN, BigDecimal.ONE)) }
  }

  @Test fun ge() {
    val cron: Cron = CronBuilder.cron(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
      .withYear(always())
      .withDoM(between(SpecialChar.L, 3))
      .withMonth(always())
      .withDoW(questionMark())
      .withHour(always())
      .withMinute(always())
      .withSecond(on(0))
      .instance()
    val cronAsString = cron.asString() // 0 * * L-3 * ? *
    System.err.println(cronAsString)
    val parse = CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
    val now = ZonedDateTime.now()
    val executionTime = ExecutionTime.forCron(parse.parse("* * * * * ? *"))
    val lastExecution: Optional<ZonedDateTime>? = executionTime.lastExecution(now)
    System.err.println(executionTime.timeToNextExecution(now))
    System.err.println(lastExecution)
  }

  @Test fun lt() {}
}
