package org.toolkit.example.vo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
@Builder
public class LoginVo {

    private String token;
}
