package org.spring.boost.minio

import org.spring.boost.minio.api.MinioDelete

class MinioDeleteTemplate(
    templateArg: MinioTemplateArgument,
) : MinioDelete, BaseTemplate(templateArg)
