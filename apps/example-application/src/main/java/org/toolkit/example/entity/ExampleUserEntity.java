package org.toolkit.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.toolkit.spring.boot.mapping.core.annotations.MappedObject;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "example_user")
@ToString
@MappedObject
public class ExampleUserEntity extends BaseEntity implements UserDetails {
	@Serial
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@Column
	private long latestLogin;

	@OneToOne
	@JoinColumn
	private ExampleUserGroupEntity userGroup;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
