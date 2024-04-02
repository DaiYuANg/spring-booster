package org.spring.boost.example.dto;

import lombok.Data;
import org.spring.boost.mapping.core.annotation.Mapping;
import org.spring.boost.mapping.core.annotation.MappingConfig;
import org.spring.boost.mapping.core.annotation.TableMapping;

@Data
public class UserDetail {

  @Mapping(
    tableMappings = {
      @TableMapping(table = "user", field = "nickname", condition = "password",
        config = @MappingConfig(fieldName = "nicknameCustom"))
    }
  )
  private String password;

  private String username;

  private boolean accountNonExpired;

  private boolean accountNonLocked;

  private boolean credentialsNonExpired;

  private boolean enabled;

}
