package org.toolkit.spring.boot.starter.minio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.starter.persistence.base.BaseEntity;

@Entity
@Setter
@Getter
@ToString
@Table(name = "toolkit_minio_resource_access")
@Accessors(chain = true)
public class MinioResourceAccessEntity extends BaseEntity {

	@Column
	private String userAgent;

	@Column
	private String host;
}
