package com.oauth.oauthserver.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //you can get the in formation from any data source as per your choice
        return new org.springframework.security.core.userdetails.User(
                username,
                passwordEncoder.encode("password"),
                getAuthority("ROLE_USER")
        );
    }

    private List<SimpleGrantedAuthority> getAuthority(String authority) {
        return Arrays.asList(new SimpleGrantedAuthority(authority));
    }
}
