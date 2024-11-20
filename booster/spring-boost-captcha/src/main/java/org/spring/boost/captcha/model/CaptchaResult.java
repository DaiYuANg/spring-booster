package org.spring.boost.captcha.model;

import io.soabase.recordbuilder.core.RecordBuilder;
import lombok.Builder;
import lombok.Data;

@RecordBuilder
public record CaptchaResult
  (
    String key, String base64Image,String code
  ) {

}
