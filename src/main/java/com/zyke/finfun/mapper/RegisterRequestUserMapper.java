package com.zyke.finfun.mapper;

import com.zyke.finfun.controller.request.RegisterRequest;
import com.zyke.finfun.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterRequestUserMapper implements ObjectMapper<RegisterRequest, User> {

    private final PasswordEncoder passwordEncoder;

    @Override
    public User map(RegisterRequest object) {

        return User.builder()
                .email(object.getEmail())
                .password(passwordEncoder.encode(object.getPassword()))
                .name(object.getName())
                .surname(object.getSurname())
                .build();
    }
}
