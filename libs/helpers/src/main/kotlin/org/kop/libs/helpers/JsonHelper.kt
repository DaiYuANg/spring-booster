package org.kop.libs.helpers

import com.google.gson.JsonParser

fun isJSONValid(test: String?): Boolean {
    return JsonParser.parseString(test).isJsonObject
}
