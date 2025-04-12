package com.sprk.spring_security_demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

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
}
