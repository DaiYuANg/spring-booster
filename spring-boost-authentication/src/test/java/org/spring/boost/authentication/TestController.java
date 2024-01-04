/* (C)2023*/
package org.spring.boost.authentication;

import jakarta.annotation.security.PermitAll;
import org.spring.boost.authentication.annotation.IgnoreAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    @RequestMapping
    public void test() {}

    @GetMapping("/test")
    @IgnoreAuthentication
    @PermitAll
    public String testUn() {
        return "";
    }
}
