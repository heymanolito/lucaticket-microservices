package com.grupo1.lucaticket.ticketpaymentservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class TokenUtil {

    public static final String TOKEN_HEADER = "Authorization";

    @Value("${jwt.secret:EnUnLugarDeLaManchaDeCuyoNombreNoQuieroAcordarmeNoHaMuchoTiempoQueViviaUnHidalgo}")
    private String jwtSecreto;

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecreto.getBytes()))
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());

    }

    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder
                        .getRequestAttributes()))
                .getRequest().getHeader(TOKEN_HEADER);
    }


}
