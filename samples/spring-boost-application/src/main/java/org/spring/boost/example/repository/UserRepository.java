package org.spring.boost.example.repository;

import org.spring.boost.example.entity.ExampleUser;
import org.spring.boost.persistence.repository.AllinOneRepository;
import org.spring.boost.persistence.repository.BaseRepository;
//import org.spring.boost.rbac.repository.SysUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AllinOneRepository<ExampleUser, Long> {


}
