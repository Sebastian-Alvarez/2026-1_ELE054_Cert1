package com.sansalibros.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "libros")
public class Libro implements Serializable {
    private String titulo;
    private String autor;
    @Id
    private String ISBN;
    private int paginas;
    private String categoria;

}
