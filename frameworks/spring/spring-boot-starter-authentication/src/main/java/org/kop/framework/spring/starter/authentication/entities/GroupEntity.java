package org.kop.framework.spring.starter.authentication.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.kop.standard.rbac.Group;

@Entity
@Getter
@Setter
public class GroupEntity extends Group {
    @Column
    private String groupAliasName1;

    @Column
    private String groupAliasName2;

    @Column
    private String groupAliasName3;

    @Column
    private String groupDescription;

    @Column
    private String groupConcatTelephone;

    @Column
    private String groupAddress;
}
