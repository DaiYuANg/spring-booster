package org.spring.boost.rbac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.spring.boost.rbac.model.PermissionGroupRefPermissionIdClass;

import static org.spring.boost.rbac.constant.FieldNaming.PERMISSION_GROUP_ID;
import static org.spring.boost.rbac.constant.FieldNaming.PERMISSION_ID;

@ToString
@Comment("系统权限组关联权限表")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Slf4j
@Setter
@Entity
@Getter
@IdClass(PermissionGroupRefPermissionIdClass.class)
public abstract class RbacPermissionGroupRefPermission {
  @Column(name = PERMISSION_ID, insertable = false, updatable = false)
  @Id
  private Long permissionId;

  @Column(name = PERMISSION_GROUP_ID, insertable = false, updatable = false)
  @Id
  private Long permissionGroupId;
}
