/* (C)2023*/
package org.spring.boost.persistence.base;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.spring.boost.persistence.annotation.SnowflakeGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@Accessors(chain = true)
@ToString
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity extends SnowflakeBaseEntity implements Serializable {
  @Column(nullable = false)
  @CreatedDate
  private Date createAt;

  @Column
  private String createBy;

  @Column
  @LastModifiedDate
  private String updateBy;

  @Column
  private Date updateAt;

  @Column
  @Version
  private Integer version;

  @Column
  private String sort;

  @Column
  String ext;
}
