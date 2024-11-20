package org.spring.boost.rbac.model;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public record PermissionGroupRefPermissionIdClass(
  Long permissionId,

  Long permissionGroupId) implements Serializable {
}
