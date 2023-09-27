package org.toolkit.spring.boot.starter.minio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.toolkit.spring.boot.starter.persistence.base.BaseEntity;

@Entity
@Setter
@Getter
@ToString
@Table(name = "toolkit_minio_resource")
public class MinioResourceEntity extends BaseEntity {

	@Column
	public String bucket;

	@Column
	private String object;

	@Column
	private String md5;
}
