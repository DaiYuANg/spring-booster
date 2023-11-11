package org.toolkit.spring.boot.route.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Table(name = "toolkit_menu")
@Setter
@Getter
public class RouteEntity extends BaseEntity {

	@Column
	private String parentId;

	@Column(unique = true)
	private String title;

	@Column
	private String description;

	@Column(unique = true)
	private String url;

	@Column
	private String component;

	@Column
	private String icon;

	@Column
	private Boolean visible;

	@Column
	private String meta;

	@Column
	private Boolean internal;

	@Column
	private Boolean external;

	@Column
	private Boolean cacheRoute;
}
