package org.toolkit.spring.boot.starter.persistence.base;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.toolkit.spring.boot.starter.persistence.listeners.BaseEntityListener;

@Getter
@Setter
@MappedSuperclass
@Accessors(chain = true)
@ToString
@EntityListeners({AuditingEntityListener.class, BaseEntityListener.class})
public class BaseEntity implements Serializable {

	@Id
	@Column(updatable = false, nullable = false)
	private String id;

	@Column(nullable = false)
	@CreatedDate
	private Date createAt;

	@Column
	private String createBy;

	@Column
	@LastModifiedDate
	private String updateBy;

	@Column
	private Date updateAt;

	@Column
	private String version;

	@Column
	String ext;
}
