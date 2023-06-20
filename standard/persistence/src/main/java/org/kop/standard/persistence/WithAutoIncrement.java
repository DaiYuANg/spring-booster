package org.kop.standard.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@ToString
@Getter
@Setter
public class WithAutoIncrement implements Serializable {

    @Id
    private Integer id;

    @Column
    private Date createAt;

    @Column
    private Date updateAt;
}
