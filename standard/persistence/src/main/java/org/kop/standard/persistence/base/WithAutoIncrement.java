package org.kop.standard.persistence.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigInteger;

@MappedSuperclass
@ToString
@Inheritance
@Getter
@Setter
public class WithAutoIncrement extends CommonField implements Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private BigInteger id;
}
