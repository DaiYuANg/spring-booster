package org.toolkit.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.mapping.core.annotations.MappedObject;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "example_user_group")
@ToString
@MappedObject
public class ExampleUserGroupEntity extends BaseEntity {

	@Column
	private String groupName;

	@Column(columnDefinition = "TEXT")
	private String groupDesc;
}
