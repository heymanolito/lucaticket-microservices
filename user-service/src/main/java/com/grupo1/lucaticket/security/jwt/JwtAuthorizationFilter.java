package com.grupo1.lucaticket.security.jwt;

import com.grupo1.lucaticket.model.UserEntity;
import com.grupo1.lucaticket.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@Component
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider tokenProvider;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            log.info("Filtro 1");
            String token = getJwtFromRequest(request);
            log.info("Filtro 2");
            if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
                Long userId = tokenProvider.getUserIdFromJWT(token);
                log.info("Filtro 3");
                UserEntity user = (UserEntity) userDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user,
                        user.getRoles(), user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        } catch (Exception ex) {
            log.info("No se ha podido establecer la autenticación de usuario en el contexto de seguridad");
        }

        filterChain.doFilter(request, response);

    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(JwtTokenProvider.TOKEN_HEADER);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(JwtTokenProvider.TOKEN_PREFIX)) {
            return bearerToken.substring(JwtTokenProvider.TOKEN_PREFIX.length(), bearerToken.length());
        }
        return null;
    }
}
