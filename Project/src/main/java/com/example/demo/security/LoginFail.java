package com.example.demo.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.provisioning.UserDetailsManager;

import java.io.IOException;

public class LoginFail implements AuthenticationFailureHandler {

    private final UserDetailsManager userDetailsManager;

    public LoginFail(UserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
    }

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            org.springframework.security.core.AuthenticationException exception
    ) throws IOException, ServletException {
        System.out.println("LOGIN FAIL HANDLER CALLED");
        String username = request.getParameter("username");

        if (!userDetailsManager.userExists(username)) {
            response.sendRedirect("/login?err=user");
        } else {
            response.sendRedirect("/login?err=pass");
        }
    }
}
