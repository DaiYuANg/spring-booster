package org.toolkit.spring.boot.starter.minio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.toolkit.spring.boot.starter.persistence.base.BaseEntity;

@Entity
@Getter
@Setter
@Table
public class MinioResourceAccessRecord extends BaseEntity {

    @Column
    private String userAgent;

    @Column
    private String ipAddress;

    @Column
    private String resourceId;

    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "resource_id")
    private MinioResourceEntity resource;
}
