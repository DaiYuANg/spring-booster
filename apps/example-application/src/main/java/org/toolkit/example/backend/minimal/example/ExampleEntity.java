package org.toolkit.example.backend.minimal.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Accessors(chain = true)
@Getter
@Setter
public class ExampleEntity extends BaseEntity {

	@Column
	private String testField;
}
