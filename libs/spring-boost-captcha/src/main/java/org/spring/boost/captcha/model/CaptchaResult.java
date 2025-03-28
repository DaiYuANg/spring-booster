package org.spring.boost.captcha.model;

import io.soabase.recordbuilder.core.RecordBuilder;
import lombok.Builder;
import lombok.Data;


/**
 * 验证码 结果
 * @param key
 * @param base64Image
 * @param code
 */
@RecordBuilder
public record CaptchaResult
  (
    String key, String base64Image,String code
  ) {

}
