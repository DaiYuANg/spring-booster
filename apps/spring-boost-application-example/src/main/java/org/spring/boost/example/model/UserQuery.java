package org.spring.boost.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.spring.boost.persistence.model.PageQuery;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class UserQuery extends PageQuery {
}
