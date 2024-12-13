package org.spring.boost.rbac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SoftDelete;
import org.spring.boost.persistence.base.BaseEntity;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Slf4j
@Getter
@Setter
@Entity
@ToString(callSuper = true)
public abstract class SysPermission extends BaseEntity {
  @Column(length = 200, nullable = false)
  @Comment("资源名称")
  private String name;

  @Column(length = 200)
  @Comment("父模块")
  @ColumnDefault("0")
  private Long parentId;

  @Comment("资源")
  @Column(nullable = false, length = 100)
  // 描述 具体模块 例如 user
  private String module;

  @Comment("权限标识符")
  @Column(length = 100, nullable = false)
  //  权限唯一标识符
  private String identifier;

  @Comment("权限描述")
  @Column(length = 200, nullable = false)
  private String description;

  /** 权限表达式 */
  @Formula("CONCAT(module,':',identifier)")
  private String expression;

  @Column
  @Comment("是否被删除")
  @SoftDelete
  private boolean deleted;
}
