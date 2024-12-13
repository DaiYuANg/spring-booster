package org.spring.boost.cli.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.shell.component.support.SelectorItem;

@RequiredArgsConstructor
@Getter
public enum CodeStyle {
  Three_Layer_Architecture("Presentation Layer,Business Logic Layer,Data Access Layer"),

  DDD("Domain,Bounded Context,Entity,Value Object,Aggregate,Domain Service,Application Service,Domain Event,Repository,Factory");

  private final String desc;

  @Contract("_ -> new")
  public static @NotNull SelectorItem<CodeStyle> buildSelectorItem(CodeStyle style) {
    return SelectorItem.of(style.name() + ":" + style.getDesc(), style, true, true);
  }
}
