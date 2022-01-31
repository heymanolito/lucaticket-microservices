package com.grupo1.lucaticket.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements UserDetails {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 6189678452627071360L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "Username nulo o vacio")
	@Size(min = 3, message = "User debe tener al menos 3 caracteres")
	@Schema(name = "Username", description = "Username del usuario")
    private String username;

    @NotEmpty(message = "Contraseña corta, nula o vacia")
	@Size(min = 3, message = "Contraseña corta debe tener al menos 3 caracteres")
	@Schema(name = "Contraseña", description = "Contraseña del usuario" )
    private String password;

    @NotEmpty(message = "Nombre corto, nulo o vacio")
	@Size(min = 3, message = "Nombre corto debe tener al menos 3 caracteres")
	@Schema(name = "Nombre completo", description = "Nombre y apellidos del usuario" )
    private String fullName;

    @NotEmpty(message = "email corto, nulo o vacio")
	@Size(min = 3, message = "Contraseña corto debe tener al menos 3 caracteres")
	@Schema(name = "Email", description = "Email del usuario" )
    @Column(unique = true)
    private String email;

    
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(ur -> new SimpleGrantedAuthority("ROLE_" + ur.name())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }

}
