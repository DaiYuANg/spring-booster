package org.toolkit.spring.boot.route.listener;

import jakarta.annotation.Resource;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.toolkit.spring.boot.route.repository.RouteEntityRepository;

@Slf4j
public class RouteEntityListener {

    @PrePersist
    public void prePersist(Object o) {
    }

    @PreUpdate
    public void preUpdate(Object o) {

    }

    @PreRemove
    public void preRemove(Object o) {

    }

    @PostLoad
    public void postLoad(Object o) {

    }

    @PostRemove
    public void postRemove(Object o) {

    }

    @PostUpdate
    public void postUpdate(Object o) {

    }

    @PostPersist
    public void postPersist(Object o) {

    }
}
