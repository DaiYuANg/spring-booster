package org.toolkit.spring.boot.persistence.base;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.toolkit.spring.boot.persistence.generators.SnowflakeGenerator;
import org.toolkit.spring.boot.persistence.listeners.BaseEntityListener;

@Getter
@Setter
@MappedSuperclass
@Accessors(chain = true)
@ToString
@EntityListeners({AuditingEntityListener.class, BaseEntityListener.class})
public class BaseEntity implements Serializable {

	@Id
	@GenericGenerator(name = "SnowflakeGenerator", type = SnowflakeGenerator.class)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SnowflakeGenerator")
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