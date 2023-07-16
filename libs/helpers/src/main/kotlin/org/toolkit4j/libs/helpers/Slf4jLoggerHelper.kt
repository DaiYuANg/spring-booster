package org.toolkit4j.libs.helpers

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T> logger(from: T): Logger {
    return LoggerFactory.getLogger(T::class.java)
}

inline fun <reified T> T.logger(from: T): Logger {
    return when {
        T::class.isCompanion -> {
            LoggerFactory.getLogger(T::class.java.enclosingClass)
        }

        else -> LoggerFactory.getLogger(T::class.java)
    }
}

abstract class Log {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)
}

class LoggerDelegate : ReadOnlyProperty<Any?, Logger> {

    companion object {
        private fun <T> createLogger(clazz: Class<T>): Logger {
            return LoggerFactory.getLogger(clazz)
        }
    }

    private var logger: Logger? = null

    override operator fun getValue(thisRef: Any?, property: KProperty<*>): Logger {
        if (logger == null) {
            logger = createLogger(thisRef!!.javaClass)
        }
        return logger!!
    }
}