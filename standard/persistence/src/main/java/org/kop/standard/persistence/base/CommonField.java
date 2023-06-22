package org.kop.standard.persistence.base;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Date;

@MappedSuperclass
@Table(indexes = {@Index(columnList = "sort")})
public class CommonField {
    @Column
    private Date createAt;

    @Column
    private String createBy;

    @Column
    private Date updateAt;

    @Column
    private String updateBy;

    @Column
    private String remark;

    @Column
    private BigInteger sort;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private BigInteger orderedByTimeStamp;

    @Column
    private int versioning;
}