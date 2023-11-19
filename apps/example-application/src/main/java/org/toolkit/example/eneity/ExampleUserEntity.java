package org.toolkit.example.eneity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "example_user")
@ToString
public class ExampleUserEntity extends BaseEntity implements UserDetails, Serializable {

	@Column
	private String username;

	@Column
	private String password;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
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
