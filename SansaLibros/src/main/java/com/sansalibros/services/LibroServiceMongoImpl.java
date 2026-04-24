package com.sansalibros.services;

import com.sansalibros.entities.Libro;
import com.sansalibros.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceMongoImpl implements LibroService{

    @Autowired
    LibrosRepository librosRepository;

    @Override
    public boolean crearLibro(Libro nuevoLibro) {
        try{
            this.librosRepository.insert(nuevoLibro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Libro> getAll() {
        return this.librosRepository.findAll();
    }

    @Override
    public List<Libro> librosByAutor(String autor) {
        return this.librosRepository.findAll()
                .stream()
                .filter(libro -> libro.getAutor().equals(autor))
                .toList();
    }
}
