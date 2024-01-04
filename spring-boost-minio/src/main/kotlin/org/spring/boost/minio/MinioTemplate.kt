package org.spring.boost.minio

import org.spring.boost.minio.api.MinioCreate
import org.spring.boost.minio.api.MinioDelete
import org.spring.boost.minio.api.MinioGet
import org.spring.boost.minio.api.MinioTemplate

class MinioTemplate(
    private val createTemplate: MinioCreateTemplate,
    private val deleteTemplate: MinioDeleteTemplate,
    private val getTemplate: MinioGetTemplate,
) : MinioGet by getTemplate, MinioCreate by createTemplate, MinioDelete by deleteTemplate
