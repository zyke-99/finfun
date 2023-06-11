package com.zyke.finfun.service;

import com.zyke.finfun.controller.request.AuthenticationRequest;
import com.zyke.finfun.controller.request.RegisterRequest;
import com.zyke.finfun.controller.response.AuthenticationResponse;
import com.zyke.finfun.mapper.ObjectMapper;
import com.zyke.finfun.model.User;
import com.zyke.finfun.model.UserPrincipal;
import com.zyke.finfun.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final ObjectMapper<User, UserPrincipal> userUserPrincipalObjectMapper;

    private final ObjectMapper<RegisterRequest, User> registerRequestUserObjectMapper;

    private final JwtService jwtService;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        final var user = registerRequestUserObjectMapper.map(request);
        userRepository.save(user);

        final var userPrinciple = userUserPrincipalObjectMapper.map(user);
        final var jwtToken = jwtService.generateToken(userPrinciple);

        return new AuthenticationResponse(jwtToken);
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        final var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        );
        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        final var user = userRepository.findByEmail(request.getEmail());
        final var token = jwtService.generateToken(userUserPrincipalObjectMapper.map(user));

        return new AuthenticationResponse(token);
    }
}
