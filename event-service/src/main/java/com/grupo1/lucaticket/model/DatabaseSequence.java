package com.grupo1.lucaticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
public @Data
@AllArgsConstructor
@NoArgsConstructor
class DatabaseSequence {

    @Id
    private String id;

    private long seq;

}
