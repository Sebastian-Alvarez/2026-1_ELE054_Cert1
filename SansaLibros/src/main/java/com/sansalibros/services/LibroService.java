package com.sansalibros.services;

import com.sansalibros.entities.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroService {
    boolean crearLibro(Libro nuevoLibro);
    List<Libro> getAll();
    List<Libro> librosByAutor(String autor);
}
