package org.toolkit.example.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.toolkit.example.dto.LoginDto;
import org.toolkit.example.eneity.ExampleUserEntity;
import org.toolkit.example.service.IExampleUserService;
import org.toolkit.example.vo.LoginVo;
import org.toolkit.spring.boot.authentication.annotation.IgnoreAuthentication;

@RestController
@RequestMapping("/example")
@Slf4j
public class ExampleUserController {

	@Resource
	private IExampleUserService exampleUserService;

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@IgnoreAuthentication
	public LoginVo test(@RequestBody LoginDto loginDto) {
		return exampleUserService.login(loginDto);
	}

	@GetMapping("/error")
	public void error(){
		System.err.println("errr");
	}

	@GetMapping("/queryList")
	public Page<ExampleUserEntity> queryList() {
		return exampleUserService.queryList();
	}
}
