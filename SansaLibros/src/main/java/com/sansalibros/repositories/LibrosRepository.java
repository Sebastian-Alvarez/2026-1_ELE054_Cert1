package com.sansalibros.repositories;

import com.sansalibros.entities.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrosRepository extends MongoRepository<Libro, String> {

}
