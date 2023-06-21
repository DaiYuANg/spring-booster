package org.kop.standard.persistence.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigInteger;
import java.util.Date;

@MappedSuperclass
public class CommonField {
    @Column
    private Date createAt;

    @Column
    private Date updateAt;

    @Column
    private String remark;

    @Column
    private BigInteger sort;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private BigInteger orderedByTimeStamp;
}
