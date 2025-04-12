package org.spring.boost.sample.rbac.entity;

import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.rbac.entity.RBACPermission;

@Entity
@Slf4j
public class Permission extends RBACPermission {
}
