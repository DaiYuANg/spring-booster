package org.toolkit.spring.boot.starter.dict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.persistence.base.SuperId;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "sys_dict")
public class Dict extends SuperId {

	@Column
	private String dictName;

	@Column
	private String dictCode;

	@Column
	private String dictText;

	@Column
	private boolean enable;
}
