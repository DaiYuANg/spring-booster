package org.toolkit4j.libs.helpers

import cn.hutool.core.date.DateUnit
import cn.hutool.core.date.DateUtil
import java.util.*

fun isAfter(date1: Date, date2: Date): Boolean {
    return DateUtil.between(date1, date2, DateUnit.SECOND) > 0;
}

fun isBefore(date1: Date, date2: Date): Boolean {
    return DateUtil.between(date1, date2, DateUnit.SECOND) < 0;
}