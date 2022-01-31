package com.grupo1.lucaticket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserEntityService userEntityService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userEntityService.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email + " no encontrado"));
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        return userEntityService.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con ID: " + id + " no encontrado"));

    }

}
