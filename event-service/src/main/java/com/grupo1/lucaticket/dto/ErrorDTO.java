package com.grupo1.lucaticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDTO {

    //private Date timestamp;
    List<String> errors;
    private int status;
    private String message;

    ErrorDTO(String message) {
        this.message = message;
    }


}
