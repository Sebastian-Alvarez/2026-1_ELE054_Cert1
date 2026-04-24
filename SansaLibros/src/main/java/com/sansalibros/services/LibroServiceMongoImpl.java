package com.sansalibros.services;

import com.sansalibros.entities.Libro;
import com.sansalibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LibroServiceMongoImpl implements LibroService{

    @Autowired
    LibrosRepository librosRepository;

    @Override
    public boolean crearLibro(Libro nuevoLibro) {
        return false;
    }

    @Override
    public List<Libro> getAll() {
        return List.of();
    }

    @Override
    public Optional<Libro> findByAutor(String autor) {
        return Optional.empty();
    }
}
