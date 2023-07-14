package org.toolkit4j.libs.helpers.math

import java.math.BigDecimal
import org.junit.jupiter.api.Test

class BigDecimalHelperKtTest {

  @Test
  fun gt() {
    kotlin.test.assertTrue { (org.toolkit4j.libs.helpers.gt(BigDecimal.TEN, BigDecimal.ONE)) }
  }

  @Test fun ge() {}

  @Test fun lt() {}
}
