package org.spring.boost.captcha.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.captcha.constant.CaptchaCharType;
import org.spring.boost.captcha.constant.CaptchaType;
import org.spring.boost.captcha.constant.ConfigConstant;
import org.spring.boost.core.autoconfigure.EnabledConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = ConfigConstant.prefix)
@Getter
@Setter
@ToString
public class CaptchaProperties {

  /**
   * 验证码类型  circle-圆圈干扰验证码|gif-Gif验证码|line-干扰线验证码|shear-扭曲干扰验证码
   */
  private CaptchaType type = CaptchaType.LINE;

  /**
   * 验证码图片宽度
   */
  private Integer width = 150;
  /**
   * 验证码图片高度
   */
  private Integer height = 50;

  /**
   * 干扰线数量
   */
  private Integer interfereCount = 4;

  /**
   * 文本透明度
   */
  private Float textAlpha = 0.9f;

  /**
   * 验证码过期时间，单位：秒
   */
  private Long expireSeconds = 3600L;

  /**
   * 验证码字符配置
   */
  @NestedConfigurationProperty
  private CodeProperties code = new CodeProperties();

  /**
   * 验证码字体
   */
  private FontProperties font = new FontProperties();
}
