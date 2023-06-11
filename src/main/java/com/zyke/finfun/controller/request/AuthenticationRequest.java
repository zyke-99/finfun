package com.zyke.finfun.controller.request;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;
}
