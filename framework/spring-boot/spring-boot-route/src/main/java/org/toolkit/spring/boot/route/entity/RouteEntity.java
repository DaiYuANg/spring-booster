/* (C)2023*/
package org.toolkit.spring.boot.route.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.persistence.base.BaseEntity;
import org.toolkit.spring.boot.route.listener.RouteEntityListener;

@Entity
@Table(name = "system_menu")
@Setter
@Getter
@ToString(callSuper = true)
@Accessors(chain = true)
@EntityListeners(RouteEntityListener.class)
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
