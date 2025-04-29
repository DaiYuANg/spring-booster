package org.spring.boost.authentication.token.redis.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class User {
  private String id;
  private String username;
}
