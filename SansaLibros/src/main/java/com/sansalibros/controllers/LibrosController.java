package com.sansalibros.controllers;

import com.sansalibros.entities.Libro;
import com.sansalibros.services.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibrosController {
    @Autowired
    private LibroService libroService;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getAll(@RequestParam(required = false) String search){
        try {
            List<Libro> listaLibros;
            if (search != null && !search.isBlank()) {
                listaLibros = this.libroService.search(search);
            } else {
                listaLibros = this.libroService.getAll();
            }
            return ResponseEntity.ok(listaLibros);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/crearLibro")
    public ResponseEntity<?> crearLibro (@Valid @RequestBody Libro nuevoLibro){
        boolean res = this.libroService.crearLibro(nuevoLibro);
        if(res){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/libros/{autor}")
    public ResponseEntity<List<Libro>> librosByAutor(@PathVariable String autor){
        try {
            List<Libro> librosDelAutor = this.libroService.librosByAutor(autor);
            if (librosDelAutor.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(librosDelAutor);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        }
}
