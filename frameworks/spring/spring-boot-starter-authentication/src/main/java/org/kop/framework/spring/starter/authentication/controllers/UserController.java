package org.kop.framework.spring.starter.authentication.controllers;

import jakarta.annotation.Resource;
import org.kop.framework.spring.starter.authentication.entity.UserEntity;
import org.kop.framework.spring.starter.authentication.services.IUserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/user")
public class UserController {

    @Resource
    private IUserServices userServices;

    @GetMapping("/list")
    public void list(UserEntity user) {
    }

    @RequestMapping(method = {RequestMethod.PUT,RequestMethod.POST},value = "/register")
    public void register(){

    }
}
