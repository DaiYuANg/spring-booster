package org.spring.boost.captcha.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.spring.boost.captcha.constant.CaptchaCharType;

@Getter
@Setter
@ToString
@Accessors(chain = true)
public class CodeProperties {
  /**
   * 验证码字符类型 math-算术|random-随机字符串
   */
  private CaptchaCharType type = CaptchaCharType.MATH;
  /**
   * 验证码字符长度，type=算术时，表示运算位数(1:个位数 2:十位数)；type=随机字符时，表示字符个数
   */
  private int length = 1;
}
