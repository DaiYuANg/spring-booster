package org.toolkit.spring.boot.starter.minio.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.toolkit.spring.boot.starter.persistence.base.BaseEntity;

@Entity
@Setter
@Getter
@Table(name = "toolkit_minio_object")
public class MinioObjectEntity extends BaseEntity {

    @Column
    private String instance;

    @Column(unique = true)
    private String object;

    @Column(unique = true)
    private String md5;

    @Column
    private String contentType;
}
