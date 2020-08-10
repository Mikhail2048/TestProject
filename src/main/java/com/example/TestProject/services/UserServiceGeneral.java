package com.example.TestProject.services;

import com.example.TestProject.models.User;
import com.example.TestProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UserServiceGeneral {

    private UserRepository userRepository;

    @Autowired
    public UserServiceGeneral(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) throws UsernameNotFoundException {
        User fetchedUser = userRepository.findByUsername(username).orElseThrow(new Supplier<UsernameNotFoundException>() {
            @Override
            public UsernameNotFoundException get() {
                return new UsernameNotFoundException("user with username " + username + "was not found");
            }
        });
        return fetchedUser;
    }
}
