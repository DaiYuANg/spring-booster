package org.spring.boost.rbac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.SoftDelete;
import org.spring.boost.persistence.base.BaseEntity;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
public class SysRole<P extends SysPermissionGroup> extends BaseEntity {
  @Column(length = 64)
  @Comment("角色名称")
  private String name;

  @Comment("角色编码")
  @Column(length = 64)
  private String code;

  @Comment("角色状态(1-正常；0-停用)")
  @Column(length = 1)
  @ColumnDefault("1")
  private Integer status;

  @Comment("逻辑删除标识(0-未删除；1-已删除)")
  @SoftDelete
  @ColumnDefault("0")
  private Boolean deleted;

  @OneToMany(fetch = FetchType.LAZY)
//  @JoinTable(
//    name = TableNaming.SYS_ROLE_REF_PERMISSION_GROUP,
//    joinColumns = {
//      @JoinColumn(
//        name = PERMISSION_GROUP_ID,
//        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    },
//    inverseJoinColumns = {
//      @JoinColumn(name = ROLE_ID, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    },
//    foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
//    inverseForeignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
  @ToString.Exclude
  private Set<P> permissionGroups;

  public Set<SysPermission> getPermissions() {
    return getPermissionGroups().stream()
      .map(SysPermissionGroup::getPermissions)
      .flatMap(Set::stream)
      .collect(toSet());
  }
}
