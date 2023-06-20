package org.kop.standard.rbac;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import org.kop.standard.persistence.WithAutoIncrement;

@Entity
public class User extends WithAutoIncrement {
}
