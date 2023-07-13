package org.kop.standard.rbac;

import jakarta.persistence.*;
import org.kop.standard.persistence.base.WithAutoIncrement;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "sys_user")
public class User extends WithAutoIncrement {
    @Column
    private String username;

    @Column
    private String password;
}
