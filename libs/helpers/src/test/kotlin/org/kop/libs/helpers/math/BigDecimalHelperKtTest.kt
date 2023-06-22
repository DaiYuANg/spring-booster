package org.kop.libs.helpers.math

import org.junit.jupiter.api.Test
import java.math.BigDecimal

class BigDecimalHelperKtTest {

    @Test
    fun gt() {
        kotlin.test.assertTrue {
            (gt(BigDecimal.TEN, BigDecimal.ONE))
        }
    }

    @Test
    fun ge() {
    }

    @Test
    fun lt() {
    }
}