package com.example.spring_cinema.models;
import jakarta.persistence.*;

//pojo class
//JPA helps import the @Annotations

@Entity(name = "movies") // creates a table called movies
public class Movie {
    @Id //same as saying primary key, the unique identifier
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generates unique number
    private Long id; //wrapper class -> capitalised

    @Column(name = "title") //creating column in table using @Column
    private String title;

    @Column(name = "rating")//takes property name by default, name -> not necessary
    private int rating;

    @Column(name = "duration")
    private int duration;

    public Movie(String title, int rating, int duration){
        this.title = title; //instantiating
        this.rating = rating;
        this.duration = duration;
    }

    public Movie(){// default constructor

    }
// GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
