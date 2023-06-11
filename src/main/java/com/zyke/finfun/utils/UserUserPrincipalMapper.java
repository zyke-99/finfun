package com.zyke.finfun.utils;

import com.zyke.finfun.auth.UserPrincipal;
import com.zyke.finfun.model.User;

import java.util.ArrayList;

public class UserUserPrincipalMapper implements ObjectMapper<User, UserPrincipal> {

    @Override
    public UserPrincipal map(User object) {

        final var userPrincipal = new UserPrincipal();
        userPrincipal.setUsername(object.getEmail());
        userPrincipal.setPassword(object.getPassword());
        userPrincipal.setAccountEnabled(true);
        userPrincipal.setAccountExpired(false);
        userPrincipal.setCredentialsExpired(false);
        userPrincipal.setCredentialsExpired(false);
        userPrincipal.setAuthorityList(new ArrayList<>());
        return userPrincipal;
    }
}
