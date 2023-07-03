package org.kop.framework.spring.boot.starter.groundwork.dict.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.kop.standard.persistence.base.WithAutoIncrement;

@Entity
@Getter
@Setter
public class Dict extends WithAutoIncrement {

    @Column
    private String dictName;

    @Column
    private String dictCode;

    @Column
    private boolean enable;
}
