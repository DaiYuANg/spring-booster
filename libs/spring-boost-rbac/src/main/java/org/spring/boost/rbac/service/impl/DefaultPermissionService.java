package org.spring.boost.rbac.service.impl;

import org.spring.boost.rbac.entity.RBACPermission;
import org.spring.boost.rbac.service.PermissionService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPermissionService<T extends RBACPermission> implements PermissionService<T> {
}
