package org.spring.boost.cli.util;

import com.github.javaparser.ParserConfiguration;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

@UtilityClass
public class LanguageLevelUtil {

  public ParserConfiguration.LanguageLevel getLanguageLevel(@NotNull String language) {
    return switch (language) {
      case "1" -> ParserConfiguration.LanguageLevel.JAVA_1_0;
      case "1.1" -> ParserConfiguration.LanguageLevel.JAVA_1_1;
      case "1.2" -> ParserConfiguration.LanguageLevel.JAVA_1_2;
      case "1.3" -> ParserConfiguration.LanguageLevel.JAVA_1_3;
      case "1.4" -> ParserConfiguration.LanguageLevel.JAVA_1_4;
      case "5" -> ParserConfiguration.LanguageLevel.JAVA_5;
      case "6" -> ParserConfiguration.LanguageLevel.JAVA_6;
      case "7" -> ParserConfiguration.LanguageLevel.JAVA_7;
      case "8" -> ParserConfiguration.LanguageLevel.JAVA_8;
      case "9" -> ParserConfiguration.LanguageLevel.JAVA_9;
      case "10" -> ParserConfiguration.LanguageLevel.JAVA_10;
      case "11" -> ParserConfiguration.LanguageLevel.JAVA_11;
      case "12" -> ParserConfiguration.LanguageLevel.JAVA_12;
      case "13" -> ParserConfiguration.LanguageLevel.JAVA_13;
      case "14" -> ParserConfiguration.LanguageLevel.JAVA_14;
//      case "15" -> ParserConfiguration.LanguageLevel.JAVA_15;
//      case "16" -> ParserConfiguration.LanguageLevel.JAVA_16;
//      case "17" -> ParserConfiguration.LanguageLevel.JAVA_17;
//      case "18" -> ParserConfiguration.LanguageLevel.JAVA_18;
//      case "19" -> ParserConfiguration.LanguageLevel.JAVA_19;
//      case "20" -> ParserConfiguration.LanguageLevel.JAVA_20;
//      case "21" -> ParserConfiguration.LanguageLevel.JAVA_21;
      default -> ParserConfiguration.LanguageLevel.CURRENT;
    };
  }
}
