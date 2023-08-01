package org.toolkit.spring.boot.authentication.entities;

import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.persistence.base.SuperId;

@ToString
@Accessors(chain = true)
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_user")
public class UserEntity extends SuperId {
	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@OneToMany
	@ToString.Exclude
	List<UserRoleEntity> userRoleEntities;

	@Column
	private int age;

	@Column
	private int sex;

	@Column
	private String phone;

	@Lob
	@Column
	private String avatar;

	//	@DomainEvents
	//	List<CompareTimingEvent<UserEntity>> compareTimingEventList() {
	//		return Collections.singletonList(new UserDomainEvent(this, this));
	//	}

	//	@AfterDomainEventPublication
	//	public void after() {
	//		compareTimingEventList().clear();
	//	}
}
