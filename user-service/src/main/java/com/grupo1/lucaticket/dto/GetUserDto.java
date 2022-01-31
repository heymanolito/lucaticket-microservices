package com.grupo1.lucaticket.dto;

import lombok.*;

import java.util.Set;

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
