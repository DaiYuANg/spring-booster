package org.toolkit.spring.boot.starter.monitor.endpoint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigInteger;
import org.toolkit.spring.boot.persistence.base.SuperId;

@Entity
@Table(name = "memory")
public class Memory extends SuperId {
	private BigInteger currentUsage;
}
