package org.kop.framework.spring.boot.starter.groundwork.tag.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.kop.standard.persistence.base.WithAutoIncrement;

@Entity
public class Tag extends WithAutoIncrement {
    @Column
    private String tagName;

    @Column
    private String tagDesc;

    @Column
    private String tagCode;

    @Column
    private String tag;
}
