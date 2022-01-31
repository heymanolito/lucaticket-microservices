package com.grupo1.lucaticket.dto;

import lombok.*;
//Este comentario no sirve
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUserDto {

    private String username;
    private String fullName;
    private String email;
    private String password;
    private String password2;

}
