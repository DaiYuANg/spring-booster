package org.toolkit.spring.boot.minio.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "toolkit_minio_object_access")
public class MinioObjectAccessEntity extends BaseEntity {

	@Column
	private String userAgent;

	@Column
	private String ipAddress;

	@Column
	private String resourceId;

	@OneToOne
	@JoinColumn(name = "id", referencedColumnName = "resource_id")
	private MinioObjectEntity resource;
}
