/* (C)2023*/
package org.spring.boost.mapping.database.source.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.spring.boost.persistence.base.BaseEntity;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
@Accessors(chain = true)
public class MappingEntity  extends BaseEntity {

    @Column
    private String naming;

    @Column
    private String code;

    @Column
    private String description;

    @Column
    private Boolean isDelete;

    @Column
    private String type;

    @JoinColumn(name = "id")
    @OneToMany
    private Set<MappingItemEntity> items;
}
