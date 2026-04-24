package com.sansalibros.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @Id
    @NotBlank
    @Size(min = 13, max = 13)
    private String ISBN;
    @Min(11 )
    private int paginas;
    @NotBlank
    private String categoria;

}
