package org.toolkit.spring.boot.website.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.toolkit.spring.boot.website.entity.AccessEntity

@Repository
interface AccessEntityRepository : JpaRepository<AccessEntity, String>, JpaSpecificationExecutor<AccessEntity>
