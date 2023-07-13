package org.toolkit4j.framework.spring.starter.monitor.endpoint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.toolkit4j.standard.persistence.base.WithAutoIncrement;

import java.math.BigInteger;

@Entity
@Table(name = "memory")
public class Memory extends WithAutoIncrement {
    private BigInteger currentUsage;
}
