package org.toolkit.example.dto;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class RegisterDto {
    private String username;

    private String password;
}
