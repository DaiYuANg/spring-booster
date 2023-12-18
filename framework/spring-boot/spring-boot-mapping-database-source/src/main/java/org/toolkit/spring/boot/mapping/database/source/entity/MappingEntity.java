/* (C)2023*/
package org.toolkit.spring.boot.mapping.database.source.entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Table
@Getter
@Setter
@Accessors(chain = true)
public class MappingEntity extends BaseEntity {

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
