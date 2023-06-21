package org.kop.standard.rbac;

import jakarta.persistence.*;
import org.kop.standard.persistence.base.WithAutoIncrement;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_group")
public class Group extends WithAutoIncrement {
    @Column
    private String groupName;

    @Column
    private String groupSubName;

    @Column
    private String groupCode;

    @Column
    private int groupLevel;

    @Column
    private Integer parentGroupId = 0;
}
