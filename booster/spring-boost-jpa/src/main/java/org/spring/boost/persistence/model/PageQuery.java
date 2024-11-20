package org.spring.boost.persistence.model;

import io.vavr.control.Option;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Slf4j
@Data
public class PageQuery {
  private final String pageNumPlaceholder = "pageNum";

  private final String pageSizePlaceholder = "pageSize";

  private Integer pageNum = 1;

  private Integer pageSize = 10;

  public Integer getPageNum() {
    return ofNullable(pageNum).orElse(1);
  }

  public Integer getPageSize() {
    return ofNullable(pageSize).orElse(10);
  }

  /**
   * 分页 页数 计算公式 == 1 提前计算首页 跳过 公式计算
   *
   * @return 第几页
   */
  public Integer getPageNumStartFromZero() {
    val computed = pageNum == 1 ? 0 : (pageNum - 1) * pageSize;
    return Math.max(computed, 0);
  }

  public Pageable pageable() {
    return PageRequest.of(getPageNum(), getPageSize());
  }

  public Pageable pageableFromZero() {
    return PageRequest.of(getPageNumStartFromZero(), getPageSize());
  }
}
