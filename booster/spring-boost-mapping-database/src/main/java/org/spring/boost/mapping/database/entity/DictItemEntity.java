package org.spring.boost.mapping.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table
@Getter
@Setter
@ToString
public class DictItemEntity {

  @Id private Long id;
}
