// (C)2024
package org.spring.boost.minio

/**
 * Naming of dynamic register bean about minio
 * @author daiyuang
 * @since 2024.1.4
 */
enum class BeanNaming(
    val naming: String,
) {
    CLIENT("Client"),

    TEMPLATE("Template"),

    ADMIN("Admin"),

    GET("Get"),

    DELETE("Delete"),
    ;

    companion object {
        private const val MIDDLE_NAMING = "minio"

        private const val PRIMARY = "primary"

        @JvmStatic
        fun buildAdminName(
            keyName: String,
            isPrimary: Boolean,
            vararg naming: BeanNaming,
        ): String {
            return """
                $keyName
                ${if (isPrimary) PRIMARY else ""}
                $MIDDLE_NAMING
                ${naming.joinToString { it.naming }}
                """.trimIndent()
        }

        @JvmStatic
        fun buildAdminName(
            keyName: String,
            vararg naming: BeanNaming,
        ): String {
            return buildAdminName(keyName, false, *naming)
        }

        @JvmStatic
        fun buildAdminName(vararg naming: BeanNaming): String {
            return buildAdminName("", true, *naming)
        }
    }
}
