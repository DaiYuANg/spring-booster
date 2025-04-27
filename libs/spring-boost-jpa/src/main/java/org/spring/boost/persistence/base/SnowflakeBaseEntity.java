package org.spring.boost.persistence.base;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.spring.boost.persistence.annotation.SnowflakeGenerator;

import java.io.Serial;
import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public class SnowflakeBaseEntity implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(generator = "SnowflakeGenerator")
  @SnowflakeGenerator
  @Column(updatable = false, nullable = false)
  private Long id;
}
