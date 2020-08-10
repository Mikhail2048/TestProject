package com.example.TestProject.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class
UserDetailsImplementation  implements UserDetails {

    private String username;
    private String password;
    private boolean activityStatus;
    private List<GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return activityStatus;
    }

    @Override
    public boolean isAccountNonLocked() {
        return activityStatus;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return activityStatus;
    }

    @Override
    public boolean isEnabled() {
        return activityStatus;
    }
}
