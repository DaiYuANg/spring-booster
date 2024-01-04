/* (C)2023*/
package org.toolkit.spring.boot.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AllinOneRepository<T, ID>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T>, PagingAndSortingRepository<T, ID> {}
