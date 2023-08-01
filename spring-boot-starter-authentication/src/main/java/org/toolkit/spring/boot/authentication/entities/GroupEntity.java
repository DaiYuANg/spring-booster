package org.toolkit.spring.boot.authentication.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.persistence.base.SuperId;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_group")
public class GroupEntity extends SuperId {

	@Column
	private String groupName;

	@Column
	private String groupSubName;

	@Column
	private String groupCode;

	@Column
	private int groupLevel;

	@Column
	private Integer parentGroupId = 0;

	@Column
	private String groupAliasName1;

	@Column
	private String groupAliasName2;

	@Column
	private String groupAliasName3;

	@Column
	private String groupDescription;

	@Column
	private String groupConcatTelephone;

	@Column
	private String groupAddress;
}
