/* (C)2023*/
package org.spring.boost.mapping.database.source.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.spring.boost.persistence.base.BaseEntity;

@Entity
@Table
@Getter
public class MappingItemEntity extends BaseEntity {

    @Column
    private String value;

    @Column
    private String text;
}
