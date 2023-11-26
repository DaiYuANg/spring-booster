package org.toolkit.spring.boot.mapping.database.source.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.toolkit.spring.boot.mapping.core.structure.MappingItem;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Table(name = "mapping_item")
@Getter
public class MappingItemEntity extends BaseEntity implements MappingItem<String> {

    @Column
    private String value;

    @Column
    private String text;
}
