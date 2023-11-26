package org.toolkit.spring.boot.mapping.database.source.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.toolkit.spring.boot.mapping.core.structure.Mapping;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

import java.util.List;

@Entity
@Table(name = "mapping", indexes = {
        @Index(name = "idx_mappingentity_naming", columnList = "naming"),
        @Index(name = "idx_mappingentity_code", columnList = "code")
})
@Getter
public class MappingEntity extends BaseEntity implements Mapping<String> {

    @Column
    private String naming;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Boolean delete;

    @Column
    private String type;

    @Column
    @OneToMany
    private List<MappingItemEntity> items;
}
