package org.kop.framework.spring.starter.authentication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.*;
import lombok.experimental.Accessors;
import org.kop.framework.spring.starter.core.repos.BasicRepository;

@ToString
@Accessors(chain = true)
@Getter
@Setter
@Entity
public class UserEntity extends BasicRepository {
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
