package org.kop.framework.spring.starter.authentication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.kop.framework.spring.starter.kernel.repos.BasicEntity;

@ToString
@Accessors(chain = true)
@Getter
@Setter
@Entity
public class UserEntity extends BasicEntity {
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String phone;

    @Lob
    @Column
    private String avatar;
}
