package com.sansalibros.controllers;

import com.sansalibros.entities.Libro;
import com.sansalibros.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
