package org.toolkit4j.framework.spring.starter.authentication.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserPojo {

    @NotBlank(message = "user name is blank")
    private String name;

    @Email(message = "email not validated")
    private String email;
}
