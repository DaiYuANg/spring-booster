package org.toolkit.spring.boot.starter.minio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.MediaType;
import org.toolkit.spring.boot.starter.persistence.base.BaseEntity;

@Entity
@Setter
@Getter
@Table
public class MinioResourceEntity extends BaseEntity {

    @Column
    private String instance;

    @Column(unique = true)
    private String path;

    @Column(unique = true)
    private String md5;

    @Column
    private boolean anonymous;

    @Column
    private String contentType;
}
