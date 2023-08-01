package org.toolkit4J.framework.spring.starter.authentication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.toolkit4J.framework.spring.starter.authentication.events.UserDomainEvent;
import org.toolkit4J.framework.spring.starter.event.spring.base.CompareTimingEvent;
import org.toolkit4J.standard.rbac.User;

@ToString
@Accessors(chain = true)
@Getter
@Setter
@Entity
public class UserEntity extends User {
	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@Column
	private int age;

	@Column
	private int sex;

	@Column
	private String phone;

	@Lob
	@Column
	private String avatar;

	@DomainEvents
	List<CompareTimingEvent<UserEntity>> compareTimingEventList() {
		return Collections.singletonList(new UserDomainEvent(this, this));
	}

	@AfterDomainEventPublication
	public void after() {
		compareTimingEventList().clear();
	}
}
