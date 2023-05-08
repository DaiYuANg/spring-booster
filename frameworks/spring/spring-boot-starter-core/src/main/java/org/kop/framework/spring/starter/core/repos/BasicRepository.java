package org.kop.framework.spring.starter.core.repos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Accessors(chain = true)
public class BasicRepository implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    private Long id;

    @Column
    private String createBy;

    @Column
    private Date createTime;

    @Column
    private String updateBy;

    @Column
    private Date updateTime;

    @Column
    private String remark;
}
