package org.toolkit4j.standard.persistence.base;

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
public class WithAutoIncrement extends CommonField implements Serializable {

	@Id
	@Column(unique = true, nullable = false, updatable = false)
	private BigInteger id;
}
