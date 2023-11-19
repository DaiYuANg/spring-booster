package org.toolkit.example.service.impl;

import cn.hutool.core.codec.Base64;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.datafaker.Faker;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;
import org.toolkit.example.dto.LoginDto;
import org.toolkit.example.dto.RegisterDto;
import org.toolkit.example.eneity.ExampleUserEntity;
import org.toolkit.example.repository.ExampleUserEntityRepository;
import org.toolkit.example.service.IExampleUserService;
import org.toolkit.example.vo.LoginVo;
import org.toolkit.spring.boot.authentication.service.IJwtService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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

    @Resource
    private SecurityFilterChain securityFilterChain;

    @PostConstruct
    public void init() {
//        val fakeData = new java.util.ArrayList<>(IntStream.range(1, 100).mapToObj(r -> {
//                    val username = faker.name().firstName() + faker.name().lastName();
//                    val password = passwordEncoder.encode(faker.internet().password());
//                    return new ExampleUserEntity()
//                            .setUsername(username)
//                            .setPassword(Base64.encode(password));
//                })
//                .toList());
        val test = new ExampleUserEntity()
                .setUsername("test")
                .setPassword(passwordEncoder.encode("test"));
        exampleUserEntityRepository.saveAndFlush(test);
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
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );
        val user = exampleUserEntityRepository
                .findByUsername(dto.getUsername())
                .orElseThrow();
        val token = jwtService.generateToken(user);
        return LoginVo.builder()
                .token(token)
                .build();
    }

    @Override
    public List<ExampleUserEntity> queryList() {
        return exampleUserEntityRepository.findAll();
    }
}
