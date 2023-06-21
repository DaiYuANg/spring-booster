package org.kop.framework.spring.starter.authentication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.kop.standard.rbac.User;

@ToString
@Accessors(chain = true)
@Getter
@Setter
@Entity
public class UserEntity extends User {
    @Column
    private String phone;

    @Lob
    @Column
    private String avatar;
}
