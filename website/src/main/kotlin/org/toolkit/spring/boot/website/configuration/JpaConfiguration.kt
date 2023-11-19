package org.toolkit.spring.boot.website.configuration

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j

@Configuration
@KotlinSlf4j
@EnableJpaRepositories("org.toolkit.spring.boot.website.repository")
@EntityScan("org.toolkit.spring.boot.website.entity")
class JpaConfiguration
