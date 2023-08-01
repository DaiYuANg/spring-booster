package org.toolkit4J.framework.spring.starter.authentication.controllers;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.toolkit4J.framework.spring.starter.authentication.entities.UserEntity;
import org.toolkit4J.framework.spring.starter.authentication.mapper.UserEntityMapper;
import org.toolkit4J.framework.spring.starter.authentication.pojo.UserPojo;
import org.toolkit4J.framework.spring.starter.authentication.services.IUserServices;

@RestController("/authentication/default/impl/user")
public class UserController {

	@Resource
	private IUserServices<UserEntity> userServices;

	@Resource
	UserEntityMapper userEntityMapper;

	@GetMapping("/list")
	public List<UserPojo> list(
			UserPojo user, @RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize) {
		return userServices
				.queryPageableList(userEntityMapper.userPojoToUserEntity(user), PageRequest.of(pageNo, pageSize))
				.stream()
				.map(userEntityMapper::userEntityToUserPojo)
				.collect(Collectors.toList());
	}

	@RequestMapping(
			method = {RequestMethod.PUT, RequestMethod.POST},
			value = "/register")
	public void register(@Validated UserPojo userPojo) {}
}
