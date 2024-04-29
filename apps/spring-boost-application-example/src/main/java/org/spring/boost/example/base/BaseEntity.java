package org.spring.boost.example.base;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
public class BaseEntity {

  @Id
  private long id;
}
