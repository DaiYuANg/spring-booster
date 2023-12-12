/* (C)2023*/
package org.toolkit.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serial;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.mapping.base.annotation.MappedObject;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "example_user_group")
@ToString
@MappedObject
public class ExampleUserGroupEntity extends BaseEntity {

	@Serial
	private static final long serialVersionUID = 1L;

	@Column
	private String groupName;

	@Column(columnDefinition = "TEXT")
	private String groupDesc;
}
