/* (C)2024*/
package org.spring.boost.office.configurations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ObjectPoolConfig {
  private boolean lifo = false;

  private int maxIdle = 10;

  private int minIdle = 10;

  private boolean testOnBorrow = true;

  private boolean testOnCreate = false;

  private boolean testOnReturn = true;

  private boolean testWhileIdle = false;
}
