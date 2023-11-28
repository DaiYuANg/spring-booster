package org.toolkit.example.eneity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.toolkit.spring.boot.mapping.core.annotations.MappedObject;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@Table(name = "example_user_group")
@ToString
@MappedObject
public class ExampleUserGroupEntity extends BaseEntity {

    private String groupName;

    private String groupDesc;
}
