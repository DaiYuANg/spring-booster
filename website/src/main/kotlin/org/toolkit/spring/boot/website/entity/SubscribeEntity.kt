package org.toolkit.spring.boot.website.entity

import jakarta.persistence.Entity
import jakarta.persistence.Table
import org.toolkit.spring.boot.persistence.base.BaseEntity

@Entity
@Table(name = "subscribe")
class SubscribeEntity(
    val address: String,
) : BaseEntity()
