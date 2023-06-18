package org.kop.framework.spring.starter.authentication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.kop.framework.spring.starter.kernel.repos.BasicEntity;

@Entity
@Getter
@Setter
public class GroupEntity extends BasicEntity {
    @Column(unique = true)
    private int groupId;

    @Column
    private String groupName;

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

    @Column
    private int groupOrder = 0;
}
