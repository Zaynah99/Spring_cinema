package com.example.spring_cinema.controllers;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.services.MovieService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


//EXTENSION
    @GetMapping(value = "/{id}")//selects a singular movie through id
    public ResponseEntity<Movie> getMovieById (@PathVariable Long id){
        Optional <Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/{id}")//selects movie via id
    public ResponseEntity<Movie> updateMovieById(@RequestParam String title, @RequestParam int rating, @RequestParam int duration){
        movieService.updateMovie("Up", 5, 110);
        Movie movie = new Movie(title, rating , duration);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }



//@PostMapping
//    public ResponseEntity<Movie> addNewMovie(@RequestParam String title, @RequestParam String rating, @RequestParam int duration){
//        movieService.addMovies(title, rating, duration);
//        Movie movie = new Movie(title, rating , duration);
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//    }
//
//
//    @PatchMapping
//    public ResponseEntity<Movie> deleteNewMovie(@RequestParam String title, @RequestParam String rating, @RequestParam int duration){
//        movieService.removeMovies(title, rating, duration);
//        Movie movie = new Movie(title, rating , duration);
//        return new ResponseEntity<>(movie, HttpStatus.CREATED);
//    }



}
