package com.grupo1.lucaticket.security.jwt.model;

import com.grupo1.lucaticket.dto.GetUserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
//sdsdsa
@Getter
@Setter
@NoArgsConstructor
public class JwtUserResponse extends GetUserDto {

    private String token;

    @Builder(builderMethodName = "jwtUserResponseBuilder")
    public JwtUserResponse(String fullName, String email, Set<String> roles, String token) {
        super(fullName, email, roles);
        this.token = token;
    }


}
