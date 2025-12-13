package com.example.demo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http,
                                    UserDetailsManager userDetailsManager) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer.requestMatchers(
                                        "/login",
                                        "/css/**",
                                        "/js/**",
                                        "/images/**",
                                        "/fonts/**",
                                        "/favicon.ico",
                                        "/json/**",
                                        "/vendor/**"
                                ).permitAll()
                                .requestMatchers("/admin/**").hasRole("MANAGER")
                                .requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .failureHandler(new LoginFail(userDetailsManager))
                                .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}

