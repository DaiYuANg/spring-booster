package org.kop.framework.spring.boot.starter.groundwork.dict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.kop.standard.persistence.base.WithAutoIncrement;

@Entity
public class Dict extends WithAutoIncrement {

    @Column
    private String dictName;

    @Column
    private String dictCode;

    @Column
    private boolean enable;
}
