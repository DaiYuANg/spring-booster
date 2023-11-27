package org.toolkit.example.service.impl;

import static java.util.stream.LongStream.range;

import jakarta.annotation.Resource;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.datafaker.Faker;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.toolkit.example.dto.LoginDto;
import org.toolkit.example.eneity.ExampleUserEntity;
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

	@Resource
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationStartedEvent.class)
	@Async
	@Override
	public void listen() {
		val faker = new Faker();
		val a = range(0, 50)
				.mapToObj(i -> new ExampleUserEntity()
						.setPassword(faker.internet().username())
						.setPassword(faker.internet().password()))
				.toList();
		val test = new ExampleUserEntity().setUsername("test").setPassword(passwordEncoder.encode("test"));
		exampleUserEntityRepository.saveAndFlush(test);
		exampleUserEntityRepository.saveAllAndFlush(a);
	}

	@EventListener(ApplicationStartedEvent.class)
	@Async
	@Override
	public void started() {
		val users = exampleUserEntityRepository.findAll();
		log.info("fake users:{}", users);
	}

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
}
