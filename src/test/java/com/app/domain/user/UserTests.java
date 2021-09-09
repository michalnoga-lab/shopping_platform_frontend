package com.app.domain.user;

import com.app.domain.user.dto.CreateUserResponseDto;
import com.app.domain.user.dto.GetUserAuthentication;
import com.app.domain.user.dto.GetUserAuthorization;
import com.app.domain.user.dto.GetUserDto;
import com.app.domain.user.type.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
public class UserTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("User activation")
    void activate() {

        User user = User.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.of(2021, 8, 24, 11, 38))
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        user.activate();

        User expectedUser = User.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.of(2021, 8, 24, 11, 38))
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(true)
                .build();

        assertThat(user).isEqualTo(expectedUser);
    }

    @Test
    @DisplayName("User to CreateUserResponseDto conversion")
    void toCreateUserResponseDto() {

        User user = User.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.now())
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        CreateUserResponseDto expectedUser = CreateUserResponseDto.builder()
                .id(1L)
                .build();

        CreateUserResponseDto userAfterChange = user.toCreateUserResponseDto();

        assertThat(userAfterChange).isEqualTo(expectedUser);
    }

    @Test
    @DisplayName("User to GetUserAuthenticationDto conversion")
    void toGetAuthenticationDto() {

        User user = User.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.now())
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        GetUserAuthentication expectedUser = GetUserAuthentication.builder()
                .email("email")
                .password("password")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        GetUserAuthentication userAfterChange = user.toGetUserAuthentication();

        assertThat(userAfterChange).isEqualTo(expectedUser);
    }

    @Test
    @DisplayName("User to GetUserAuthorization conversion")
    void toGetUserAuthorization() {

        User user = User.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.now())
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        GetUserAuthorization expectedUser = GetUserAuthorization
                .builder()
                .email("email")
                .build();

        GetUserAuthorization userAfterChange = user.toGetAuthorization();

        assertThat(userAfterChange).isEqualTo(expectedUser);
    }

    @Test
    @DisplayName("User to GetUserDto conversion")
    void toGetUserDto() {

        User user = User.builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.of(2021, 8, 24, 11, 38))
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        GetUserDto expectedUser = GetUserDto
                .builder()
                .id(1L)
                .name("name")
                .surname("surname")
                .email("email")
                .password("password")
                .createdAt(LocalDateTime.of(2021, 8, 24, 11, 38))
                .accountCreationIp("0.0.0.0")
                .lastLoginIp("0.0.0.0")
                .role(Role.ROLE_USER)
                .enabled(false)
                .build();

        GetUserDto userAfterChange = user.toGetUserDto();

        assertThat(userAfterChange).isEqualTo(expectedUser);
    }
}