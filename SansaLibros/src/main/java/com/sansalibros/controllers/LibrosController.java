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
    public ResponseEntity<List<Libro>> getAll(){
        try {
            List<Libro> listaLibros = this.libroService.getAll();
            return  ResponseEntity.ok(listaLibros);
        } catch (Exception e) {
            //Si hay algun fallo en la peticion se captura y se devuelve un internar server error (500)
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
