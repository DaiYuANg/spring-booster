package org.spring.boost.rbac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;
import org.hibernate.envers.NotAudited;
import org.spring.boost.persistence.base.BaseEntity;

import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class SysPermissionGroup extends BaseEntity {
  @Column(nullable = false)
  @Comment("权限组名称 在租户环境下是唯一的")
  private String groupName;

  @Comment("权限组Code")
  @Column
  private String groupCode;

  @Comment("权限组 描述")
  private String description;

  @OneToMany(fetch = FetchType.LAZY)
//  @JoinTable(
//    name = TableNaming.SYS_PERMISSION_GROUP_REF_PERMISSION,
//    joinColumns = {
//      @JoinColumn(
//        name = PERMISSION_GROUP_ID,
//        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    },
//    inverseJoinColumns = {
//      @JoinColumn(name = PERMISSION_ID, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    },
//    foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
//    inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
  @ToString.Exclude
  @NotAudited
  private Set<RBACPermission> permissions;
}
