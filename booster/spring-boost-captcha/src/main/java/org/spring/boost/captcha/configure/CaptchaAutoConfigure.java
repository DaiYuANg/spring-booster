package org.spring.boost.captcha.configure;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.captcha.constant.ConfigConstant;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.awt.Font;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(CaptchaProperties.class)
@RequiredArgsConstructor
public class CaptchaAutoConfigure {


  @Bean
  @ConditionalOnProperty(prefix = ConfigConstant.prefix + "code.type", value = "MATH")
  public CodeGenerator mathCodeGenerator(@NotNull CaptchaProperties captchaProperties) {
    val codeLength = captchaProperties.getCode().getLength();
    return new MathGenerator(codeLength);
  }

  @Bean
  @ConditionalOnProperty(prefix = ConfigConstant.prefix + "code.type", value = "RANDOM")
  public CodeGenerator randomCodeGenerator(@NotNull CaptchaProperties captchaProperties) {
    val codeLength = captchaProperties.getCode().getLength();
    return new RandomGenerator(codeLength);
  }

  /**
   * 验证码字体
   */
  @Bean
  @ConditionalOnProperty(prefix = ConfigConstant.prefix+"enabled",value = "true")
  public Font captchaFont(@NotNull CaptchaProperties captchaProperties) {
    String fontName = captchaProperties.getFont().getName();
    int fontSize = captchaProperties.getFont().getSize();
    int fontWeight = captchaProperties.getFont().getWeight();

    int awtFontStyle = switch (fontWeight) {
      case 1 -> Font.PLAIN;
      case 2 -> Font.BOLD;
      case 3 -> Font.ITALIC;
      default -> throw new IllegalArgumentException("Invalid font weight: " + fontWeight);
    };

    return Font.getFont(fontName)
      .deriveFont(awtFontStyle, fontSize);
  }
}
