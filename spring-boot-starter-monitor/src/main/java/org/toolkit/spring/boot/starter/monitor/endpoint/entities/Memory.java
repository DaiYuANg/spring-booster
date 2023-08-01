package org.toolkit.spring.boot.starter.monitor.endpoint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigInteger;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

@Entity
@Table(name = "memory")
public class Memory extends WithAutoIncrement {
	private BigInteger currentUsage;
}
