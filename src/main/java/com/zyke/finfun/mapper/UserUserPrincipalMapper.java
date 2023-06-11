package com.zyke.finfun.mapper;

import com.zyke.finfun.model.UserPrincipal;
import com.zyke.finfun.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
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
