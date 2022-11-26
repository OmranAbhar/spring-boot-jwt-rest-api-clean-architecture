package com.clean.app.common.jwt.service;

import com.clean.app.common.encryption.Encryption;
import com.clean.app.common.jwt.repository.UserRepository;
import com.clean.app.common.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(),Encryption.DecryptPassword(user.getEmail(),user.getPassword()), new ArrayList<>());
    }
}
