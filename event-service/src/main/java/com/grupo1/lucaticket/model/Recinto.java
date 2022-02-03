package com.grupo1.lucaticket.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Document
@Schema(name = "Recinto", description = "Clase recinto")
public @Data
@AllArgsConstructor
@NoArgsConstructor
class Recinto {

    @Id
    private int id;
    @NotEmpty
    @Size(min = 3)
    @Schema(name = "Nombre", description = "Nombre del recinto ")
    private String nombre;
    @NotEmpty
    @Size(min = 3)
    @Schema(name = "Ciudad", description = "Ciudad del recinto ")
    private String ciudad;
    @NotEmpty
    @Size(min = 3)
    @Schema(name = "Direccion", description = "Direccion del recinto ")
    private String direccion;
    @NotEmpty
    @Size(min = 3)
    @Schema(name = "Aforo", description = "Aforo del recinto")
    private Integer aforo;

    @Override
    public String toString() {
        return String.format(
                "Event[id=%s, nombre='%s', ciudad='%s', direccion='%s', aforo='%s'",
                id, nombre, ciudad, direccion, aforo);
    }
}
