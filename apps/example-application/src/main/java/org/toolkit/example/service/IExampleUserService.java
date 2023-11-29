package org.toolkit.example.service;

import org.springframework.data.domain.Page;
import org.toolkit.example.dto.LoginDto;
import org.toolkit.example.entity.ExampleUserEntity;
import org.toolkit.example.vo.LoginVo;

public interface IExampleUserService {
	LoginVo login(LoginDto dto);

	Page<ExampleUserEntity> queryList();
}
