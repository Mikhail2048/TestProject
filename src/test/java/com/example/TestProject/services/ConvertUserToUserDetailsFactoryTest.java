package com.example.TestProject.services;

import com.example.TestProject.models.EntityStatus;
import com.example.TestProject.models.Role;
import com.example.TestProject.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static com.example.TestProject.services.ConvertUserToUserDetailsFactory.convertUserToUserDetails;

@ExtendWith({
        SpringExtension.class,
        MockitoExtension.class
})
class ConvertUserToUserDetailsFactoryTest {

    @Test
    void convertUserToUserDetailsTest() {

        String password = "user_password";
        String username = "user_login";
        String roleName = "USER";

        User userToConvert = new User();
        userToConvert.setPassword(password);
        userToConvert.setUsername(username);

        Role role = new Role();
        role.setName(roleName);
        userToConvert.setRoles(Arrays.asList(role));

        userToConvert.setStatus(EntityStatus.ACTIVE);

        Assertions.assertEquals(password, convertUserToUserDetails(userToConvert).getPassword());

        Assertions.assertEquals(username,
                convertUserToUserDetails(userToConvert).getUsername());

        Assertions.assertEquals(true,
                convertUserToUserDetails(userToConvert).isEnabled());

        GrantedAuthority grantedAuthority = convertUserToUserDetails(userToConvert).getAuthorities().iterator().next();
        Assertions.assertEquals("ROLE_" + roleName, grantedAuthority.getAuthority());
    }
}