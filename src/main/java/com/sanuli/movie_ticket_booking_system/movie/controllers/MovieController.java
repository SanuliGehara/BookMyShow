package com.sanuli.movie_ticket_booking_system.movie.controllers;

import com.sanuli.movie_ticket_booking_system.movie.request.MovieRequest;
import com.sanuli.movie_ticket_booking_system.movie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addMovie(@RequestBody MovieRequest movieRequest) {
        try {
            String result = movieService.addMovie(movieRequest);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}