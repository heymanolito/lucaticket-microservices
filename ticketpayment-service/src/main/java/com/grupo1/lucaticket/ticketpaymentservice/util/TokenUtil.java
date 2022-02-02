package com.grupo1.lucaticket.ticketpaymentservice.util;

import com.grupo1.lucaticket.ticketpaymentservice.controller.PaymentController;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class TokenUtil {

    public static final String TOKEN_HEADER = "Authorization";
    private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);
    static String jwtSecreto = "EnUnLugarDeLaManchaDeCuyoNombreNoQuieroAcordarmeNoHaMuchoTiempoQueViviaUnHidalgo";

    public static Long getUserIdFromJWT(String token) {
        String newToken = token.substring(7);

        log.info(jwtSecreto);
        log.info("NEW TOKEN: " + newToken);
        log.info("Dentro de getuserfromjwt");
        log.info("Token" + token);
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(jwtSecreto.getBytes()))
                .parseClaimsJws(newToken)
                .getBody();
        log.info("- - - - - CLAIMS" + claims);
        return Long.parseLong(claims.getSubject());

    }

    public static String getBearerTokenHeader() {
        return ((ServletRequestAttributes)
                Objects.requireNonNull(RequestContextHolder
                        .getRequestAttributes()))
                .getRequest().getHeader(TOKEN_HEADER);
    }


}
