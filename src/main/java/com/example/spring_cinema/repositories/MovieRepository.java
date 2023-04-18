package com.example.spring_cinema.repositories;

import com.example.spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {// connects model to database
    //implement JPO repository
    //gives access to save, delete, find etc. id
    // an interface(like a library)

}
