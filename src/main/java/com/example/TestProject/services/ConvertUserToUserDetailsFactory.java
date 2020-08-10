package com.example.TestProject.services;

import com.example.TestProject.models.EntityStatus;
import com.example.TestProject.models.Role;
import com.example.TestProject.models.User;
import com.example.TestProject.models.UserDetailsImplementation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class ConvertUserToUserDetailsFactory {

    private ConvertUserToUserDetailsFactory() {
    }

    public static UserDetails convertUserToUserDetails(User userToConvert) {

        UserDetails userDetailsToReturn = new UserDetailsImplementation(
                userToConvert.getUsername(),
                userToConvert.getPassword(),
                userToConvert.getStatus().equals(EntityStatus.ACTIVE),
                convertUserRolesIntoGrantedAuthorities(userToConvert.getRoles())
        );

        return userDetailsToReturn;
    }

    private static List<GrantedAuthority> convertUserRolesIntoGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());
    }
}
