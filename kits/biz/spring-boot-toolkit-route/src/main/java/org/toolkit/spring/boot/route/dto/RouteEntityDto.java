package org.toolkit.spring.boot.route.dto;

import jakarta.validation.constraints.NotBlank;
import java.io.Serializable;
import org.toolkit.spring.boot.route.entity.RouteEntity;

/**
 * DTO for {@link RouteEntity}
 */
public record RouteEntityDto(
		@NotBlank String parentId,
		@NotBlank String title,
		String description,
		@NotBlank String url,
		@NotBlank String component,
		String icon,
		Boolean visible,
		String meta,
		Boolean internal,
		Boolean external,
		Boolean cacheRoute)
		implements Serializable {}
