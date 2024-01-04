package org.spring.boost.minio

import org.spring.boost.minio.api.MinioAdmin
import org.spring.boost.minio.api.MinioCreate
import org.spring.boost.minio.api.MinioDelete
import org.spring.boost.minio.api.MinioGet

class MinioTemplate private constructor(
    private val createTemplate: MinioCreateTemplate,
    private val deleteTemplate: MinioDeleteTemplate,
    private val getTemplate: MinioGetTemplate,
    private val adminTemplate: MinioAdminTemplate,
    templateArg: MinioTemplateArgument,
) : MinioGet by getTemplate,
    MinioCreate by createTemplate,
    MinioDelete by deleteTemplate,
    MinioAdmin by adminTemplate,
    BaseTemplate(templateArg) {
    companion object {
        @JvmStatic
        @JvmOverloads
        fun builder(
            createTemplate: MinioCreateTemplate = MinioCreateTemplate(),
            deleteTemplate: MinioDeleteTemplate = MinioDeleteTemplate(),
            getTemplate: MinioGetTemplate = MinioGetTemplate(),
            adminTemplate: MinioAdminTemplate = MinioAdminTemplate(),
            templateArg: MinioTemplateArgument = MinioTemplateArgument.builder().build(),
        ): Builder {
            return Builder(createTemplate, deleteTemplate, getTemplate, adminTemplate, templateArg)
        }
    }

    class Builder(
        private var createTemplate: MinioCreateTemplate,
        private var deleteTemplate: MinioDeleteTemplate,
        private var getTemplate: MinioGetTemplate,
        private var adminTemplate: MinioAdminTemplate,
        private var templateArg: MinioTemplateArgument,
    ) {
        fun createTemplate(createTemplate: MinioCreateTemplate) = apply { this.createTemplate = createTemplate }

        fun deleteTemplate(deleteTemplate: MinioDeleteTemplate) = apply { this.deleteTemplate = deleteTemplate }

        fun getTemplate(getTemplate: MinioGetTemplate) = apply { this.getTemplate = getTemplate }

        fun adminTemplate(adminTemplate: MinioAdminTemplate) = apply { this.adminTemplate = adminTemplate }

        fun templateArg(templateArg: MinioTemplateArgument) = apply { this.templateArg = templateArg }

        fun build() = MinioTemplate(createTemplate, deleteTemplate, getTemplate, adminTemplate, templateArg)
    }
}
