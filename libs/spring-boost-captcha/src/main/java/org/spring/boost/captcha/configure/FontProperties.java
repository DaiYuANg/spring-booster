package org.spring.boost.captcha.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FontProperties {
  /**
   * 字体名称
   */
  private String name;
  /**
   * 字体样式  0-普通|1-粗体|2-斜体
   */
  private int weight;
  /**
   * 字体大小
   */
  private int size;
}
