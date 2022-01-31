package com.grupo1.lucaticket.dto.adapter;

import com.grupo1.lucaticket.dto.GetUserDto;
import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
        return GetUserDto.builder()
                .username(user.getUsername())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(UserRole::name)
                        .collect(Collectors.toSet())
                ).build();
    }
    public List<GetUserDto> of(List<UserEntity> user) {
        return user.stream().map(this::convertUserEntityToGetUserDto).collect(Collectors.toList());
    }

}
