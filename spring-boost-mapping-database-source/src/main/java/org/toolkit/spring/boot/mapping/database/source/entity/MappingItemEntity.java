/* (C)2023*/
package org.toolkit.spring.boot.mapping.database.source.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Table
@Getter
public class MappingItemEntity extends BaseEntity {

    @Column
    private String value;

    @Column
    private String text;
}
