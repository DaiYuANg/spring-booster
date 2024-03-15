package org.spring.boost.minio

import org.spring.boost.minio.api.MinioDelete

class MinioDeleteTemplate
    @JvmOverloads
    constructor(
        templateArg: MinioTemplateArgument = MinioTemplateArgument.builder().build(),
    ) : MinioDelete, BaseTemplate(templateArg)
