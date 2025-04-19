package com.sprk.spring_security_demo.controller;

import com.sprk.spring_security_demo.entity.UserInfo;
import com.sprk.spring_security_demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/")
    public String index() {
        return "Welcome to INDEX";
    }

    @GetMapping("/home")
    public String home() {
        return "Welcome to Spring Security Demo HOME PAGE";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Security Demo WELCOME";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin() {
        return "Welcome to Spring Security Demo ADMIN PAGE";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String user() {
        return "Welcome to Spring Security Demo USER PAGE";
    }

    @GetMapping("/tester")
    @PreAuthorize("hasAuthority('ROLE_TESTER')")
    public String tester() {
        return "Welcome to Spring Security Demo TESTER PAGE";
    }

    @PostMapping("/signup")
    public UserInfo signup(@RequestBody UserInfo userInfo) {
        UserInfo info = userInfoService.saveUserInfo(userInfo);
        return info;
    }
}
