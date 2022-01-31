package com.grupo1.lucaticket.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetUserDto {

    private String username;
    private String fullName;
    private String email;
    private Set<String> roles;


    public GetUserDto(String fullName, String email, Set<String> roles) {
        this.fullName = fullName;
        this.email = email;
        this.roles = roles;
    }
}
