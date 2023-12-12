/* (C)2023*/
package org.toolkit.example.service.impl;

import jakarta.annotation.Resource;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.toolkit.example.dto.LoginDto;
import org.toolkit.example.entity.ExampleUserEntity;
import org.toolkit.example.repository.ExampleUserEntityRepository;
import org.toolkit.example.service.IExampleUserService;
import org.toolkit.example.vo.LoginVo;
import org.toolkit.spring.boot.authentication.service.IJwtService;

@Service
@Slf4j
public class ExampleUserServiceImpl implements IExampleUserService {
	@Resource
	private ExampleUserEntityRepository exampleUserEntityRepository;

	@Resource
	private AuthenticationManager authenticationManager;

	@Resource
	private IJwtService jwtService;

	@Override
	public LoginVo login(@NotNull LoginDto dto) {
		log.info("user login dto:{}", dto);
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		val user = exampleUserEntityRepository.findByUsername(dto.getUsername()).orElseThrow();
		val token = jwtService.generateToken(user);
		user.setLatestLogin(new Date().getTime());
		exampleUserEntityRepository.save(user);
		return LoginVo.builder().token(token).build();
	}

	@Override
	public Page<ExampleUserEntity> queryList() {
		return exampleUserEntityRepository.findAll(Pageable.ofSize(20));
	}

	public void queryByExample() {
		val e = ExampleMatcher.matching().withMatcher("username", matcher -> {
			matcher.startsWith();
			matcher.endsWith();
			matcher.contains();
		});
		val entity = new ExampleUserEntity();
		val example = Example.of(entity, e);
		exampleUserEntityRepository.findAll(example);
	}
}
