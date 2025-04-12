package com.sprk.spring_security_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringConfig {


    /*@Bean
    public UserDetailsService userDetailsService() {

        UserDetails abdul = User
                .withUsername("Abdul")
                .password("{noop}1234")
                .roles("USER")
                .build();

        UserDetails rohan = User
                .withUsername("Rohan")
                .password("{noop}4567")
                .roles("USER","ADMIN")
                .build();

        UserDetails parth = User
                .withUsername("Parth")
                .password("{noop}8767")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(abdul, rohan, parth);
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf ->
                csrf.disable()
        );
        http.authorizeHttpRequests(req ->
                req
                        .requestMatchers("/", "/welcome")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
        );
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();

    }
}
