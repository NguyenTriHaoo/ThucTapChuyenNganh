package com.example.demo.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final DataSource dataSource;

    public CustomOAuth2UserService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");

        try (Connection conn = dataSource.getConnection()) {

            // Kiểm tra user
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT username FROM users WHERE username = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                // Tạo user
                PreparedStatement insertUser = conn.prepareStatement(
                        "INSERT INTO users(username, password, enabled) VALUES (?, ?, ?)");
                insertUser.setString(1, email);
                insertUser.setString(2, "{noop}");
                // password giả để ko bị null cột password, user ko dung password
                insertUser.setInt(3, 1);
                insertUser.executeUpdate();

                // Cấp quyền
                PreparedStatement insertRole = conn.prepareStatement(
                        "INSERT INTO authorities(username, authority) VALUES (?, ?)");
                insertRole.setString(1, email);
                insertRole.setString(2, "ROLE_EMPLOYEE");
                insertRole.executeUpdate();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new org.springframework.security.oauth2.core.user.DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                oAuth2User.getAttributes(),
                "email"
        );
    }
}
