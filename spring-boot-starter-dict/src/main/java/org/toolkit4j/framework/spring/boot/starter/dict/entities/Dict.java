package org.toolkit4j.framework.spring.boot.starter.dict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class Dict extends WithAutoIncrement {

	@Column
	private String dictName;

	@Column
	private String dictCode;

	@Column
	private String dictText;

	@Column
	private boolean enable;
}
