package org.spring.boost.captcha.configure;

import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.captcha.generator.RandomGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.captcha.constant.ConfigConstant;
import org.spring.boost.captcha.service.CaptchaService;
import org.spring.boost.captcha.service.CaptchaServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.awt.Font;
import java.util.Optional;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(CaptchaProperties.class)
@RequiredArgsConstructor
public class CaptchaAutoConfigure {
  @Bean
  CodeGenerator captchaCodeGenerator(@NotNull CaptchaProperties captchaProperties) {
    val codeLength = captchaProperties.getCode().getLength();
    return switch (captchaProperties.getCode().getType()) {
      case MATH -> new MathGenerator(codeLength);
      case RANDOM -> new RandomGenerator(codeLength);
    };
  }

  /**
   * 验证码字体
   */
  @Bean
  Font captchaFont(@NotNull CaptchaProperties captchaProperties) {
    val fontName = captchaProperties.getFont().getName();
    val fontSize = captchaProperties.getFont().getSize();
    val fontWeight = captchaProperties.getFont().getWeight();

    val awtFontStyle = switch (fontWeight) {
      case 0 -> Font.PLAIN;
      case 1 -> Font.BOLD;
      case 2 -> Font.ITALIC;
      default -> throw new IllegalArgumentException("Invalid font weight: " + fontWeight);
    };

    return new Font(fontName, awtFontStyle, fontSize);
  }

  @Bean
  @ConditionalOnMissingBean
  CaptchaService captchaService(
    CodeGenerator codeGenerator,
    CaptchaProperties captchaProperties,
    Font font
  ) {
    return new CaptchaServiceImpl(codeGenerator, captchaProperties, font);
  }
}
