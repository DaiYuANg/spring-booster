package org.toolkit.spring.boot.persistence.base;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@ToString
@Inheritance
@Getter
@Setter
public class SuperId extends CommonField implements Serializable {

	@Id
	@Column(unique = true, nullable = false, updatable = false)
	private BigInteger id;

	@PrePersist
	public void prePersist() {}
}
