package org.spring.boost.minio

class MinioTemplate(
    private val createTemplate: MinioCreateTemplate,
    private val deleteTemplate: MinioDeleteTemplate,
    private val getTemplate: MinioGetTemplate,
) : MinioGet by getTemplate, MinioCreate by createTemplate, MinioDelete by deleteTemplate
