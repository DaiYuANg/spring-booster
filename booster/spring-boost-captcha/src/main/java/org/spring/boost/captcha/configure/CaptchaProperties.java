package org.spring.boost.captcha.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.captcha.constant.CaptchaType;
import org.spring.boost.captcha.constant.ConfigConstant;
import org.spring.boost.core.autoconfigure.EnabledConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = ConfigConstant.prefix)
@Getter
@Setter
@ToString
public class CaptchaProperties extends EnabledConfigurationProperties {

  /**
   * 验证码类型  circle-圆圈干扰验证码|gif-Gif验证码|line-干扰线验证码|shear-扭曲干扰验证码
   */
  private CaptchaType type;

  /**
   * 验证码图片宽度
   */
  private int width;
  /**
   * 验证码图片高度
   */
  private int height;

  /**
   * 干扰线数量
   */
  private int interfereCount;

  /**
   * 文本透明度
   */
  private Float textAlpha;

  /**
   * 验证码过期时间，单位：秒
   */
  private Long expireSeconds;

  /**
   * 验证码字符配置
   */
  private CodeProperties code;

  /**
   * 验证码字体
   */
  private FontProperties font;
}
