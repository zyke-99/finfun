package com.zyke.finfun.service;

import com.zyke.finfun.model.UserPrincipal;
import com.zyke.finfun.mapper.ObjectMapper;
import com.zyke.finfun.model.User;
import com.zyke.finfun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper<User, UserPrincipal> userUserPrincipalObjectMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final var user = userRepository.findByEmail(username);
        return userUserPrincipalObjectMapper.map(user);
    }
}
