package com.grupo1.lucaticket.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombreEvento;

    @ManyToOne
    private UserEntity user;
}
