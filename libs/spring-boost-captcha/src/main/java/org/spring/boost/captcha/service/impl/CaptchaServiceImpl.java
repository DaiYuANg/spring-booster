package org.spring.boost.captcha.service.impl;

import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.generator.CodeGenerator;
import cn.hutool.core.util.IdUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.captcha.configure.CaptchaProperties;
import org.spring.boost.captcha.model.CaptchaResult;
import org.spring.boost.captcha.model.CaptchaResultBuilder;
import org.spring.boost.captcha.service.CaptchaService;

import java.awt.*;

@Slf4j
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

  private final CodeGenerator codeGenerator;

  private final CaptchaProperties captchaProperties;

  private final Font captchaFont;

  @Override
  public CaptchaResult generate() {
    AbstractCaptcha captcha;
    val width = captchaProperties.getWidth();
    val height = captchaProperties.getHeight();
    val interfereCount = captchaProperties.getInterfereCount();
    val codeLength = captchaProperties.getCode().getLength();
    val type = captchaProperties.getType();
    switch (type) {
      case CIRCLE -> captcha = CaptchaUtil.createCircleCaptcha(width, height, codeLength, interfereCount);
      case GIF -> captcha = CaptchaUtil.createGifCaptcha(width, height, codeLength);
      case LINE -> captcha = CaptchaUtil.createLineCaptcha(width, height, codeLength, interfereCount);
      case SHEAR -> captcha = CaptchaUtil.createShearCaptcha(width, height, codeLength, interfereCount);
      default -> throw new IllegalArgumentException("Invalid captcha type: " + type);
    }

    captcha.setGenerator(codeGenerator);
    captcha.setTextAlpha(captchaProperties.getTextAlpha());
    captcha.setFont(captchaFont);

    return CaptchaResultBuilder.builder()
      .key(IdUtil.fastUUID())
      .code(captcha.getCode())
      .base64Image(captcha.getImageBase64Data())
      .build();
  }
}
