package org.spring.boost.mapping.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Comment;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table
@Getter
@Setter
@ToString
public class DictEntity {

  @Id private long id;

  @Column
  @Comment("Dict code")
  private String code;

  private String name;

  private String description;

  private long order;
}
