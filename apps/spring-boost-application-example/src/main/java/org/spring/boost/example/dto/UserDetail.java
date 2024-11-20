package org.spring.boost.example.dto;

import lombok.Data;

@Data
public class UserDetail {

  private String password;

  private String username;

  private boolean accountNonExpired;

  private boolean accountNonLocked;

  private boolean credentialsNonExpired;

  private boolean enabled;

}
