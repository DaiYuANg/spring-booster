package org.spring.boost.captcha.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaptchaResult {
  private String key;
  private String base64Image;
  private String code;
}
