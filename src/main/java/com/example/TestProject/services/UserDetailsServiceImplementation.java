package com.example.TestProject.services;

import com.example.TestProject.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    private PasswordEncoder passwordEncoder;

    private UserServiceGeneral userServiceGeneral;

    @Autowired
    public UserDetailsServiceImplementation(PasswordEncoder passwordEncoder, UserServiceGeneral userServiceGeneral) {
        this.passwordEncoder = passwordEncoder;
        this.userServiceGeneral = userServiceGeneral;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User fetchedUser = userServiceGeneral.getUserByUsername(username);
        return null;
    }
}
