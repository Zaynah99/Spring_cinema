package com.example.spring_cinema.services;

import com.example.spring_cinema.models.Movie;
import com.example.spring_cinema.repositories.MovieRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;//object

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();// repository is link between application and database
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public void updateMovie(String title, int rating, int duration){
        Movie movie = new Movie (title, rating, duration);
        movieRepository.save(movie);
    }


}
