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

}
