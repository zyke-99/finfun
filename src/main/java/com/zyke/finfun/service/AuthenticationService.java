package com.zyke.finfun.service;

import com.zyke.finfun.controller.request.AuthenticationRequest;
import com.zyke.finfun.controller.request.RegisterRequest;
import com.zyke.finfun.controller.response.AuthenticationResponse;

public interface AuthenticationService {
    
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
