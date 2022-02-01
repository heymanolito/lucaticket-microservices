package com.grupo1.lucaticket.security.jwt;

import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.model.UserRole;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Log
@Component
@Getter
public class JwtTokenProvider {

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";

    @Value("${jwt.secret:EnUnLugarDeLaManchaDeCuyoNombreNoQuieroAcordarmeNoHaMuchoTiempoQueViviaUnHidalgo}")
    private String jwtSecreto;

    @Value("${jwt.token-expiration:86400}")
    private int jwtDuracionTokenEnSegundos;

    public String generateToken(Authentication authentication) {

        UserEntity user = (UserEntity) authentication.getPrincipal();

        Date tokenExpirationDate = new Date(System.currentTimeMillis() + (jwtDuracionTokenEnSegundos * 1000L));
        log.info("Generando token...");
        return Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(jwtSecreto.getBytes()), SignatureAlgorithm.HS512)
                .setHeaderParam("typ", TOKEN_TYPE)
                .setSubject(Long.toString(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(tokenExpirationDate)
                .claim("fullname", user.getFullName())
                .claim("roles", user.getRoles().stream()
                        .map(UserRole::name)
                        .collect(Collectors.joining(", "))
                )
                .compact();

    }


    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecreto.getBytes()))
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());

    }


    public boolean validateToken(String authToken) {
        log.info("Validando el token en Token Provider.");
        try {
            Jwts.parser().setSigningKey(jwtSecreto.getBytes()).parseClaimsJws(authToken);
            log.info("Validando token...");
            return true;
        } catch (SignatureException ex) {
            log.info("Error en la firma del token JWT: " + ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.info("Token malformado: " + ex.getMessage());
        } catch (ExpiredJwtException ex) {
            log.info("El token ha expirado: " + ex.getMessage());
        } catch (UnsupportedJwtException ex) {
            log.info("Token JWT no soportado: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.info("JWT claims vacío");
        }
        return false;


    }


}
