package org.toolkit.spring.boot.starter.minio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.toolkit.spring.boot.starter.persistence.base.BaseEntity;

@Entity
@Setter
@Getter
@Table(name = "toolkit_minio_resource_access")
public class MinioResourceAccessEntity extends BaseEntity {

	@Column
	private String userAgent;
}
