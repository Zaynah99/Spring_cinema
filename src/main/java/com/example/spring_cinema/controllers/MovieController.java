package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/movies") //sets default route
public class MovieController {

    @Autowired
    MovieService movieService;

// Index route (getAllMovies)

    @GetMapping // bolts onto request mapping
    public ResponseEntity<List<Movie>> getAllMovies(){ //contains all movies into list variable which allows to wrap around
        List<Movie> movies = movieService.getAllMovies();// calling list of movie movies,
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<Movie>> postMovie(@RequestBody Movie movie){ //adding to movies
        movieService.saveMovie(movie); //saving movie
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.CREATED); // allow returning more than one item

    }




}