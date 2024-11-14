package com.sanuli.movie_ticket_booking_system.movie.services;

import com.sanuli.movie_ticket_booking_system.movie.convertor.MovieConvertor;
import com.sanuli.movie_ticket_booking_system.movie.enitites.Movie;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.MovieAlreadyExist;
import com.sanuli.movie_ticket_booking_system.movie.repositories.MovieRepository;
import com.sanuli.movie_ticket_booking_system.movie.request.MovieRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(MovieRequest movieRequest) {
        Movie movieByName = movieRepository.findByMovieName(movieRequest.getMovieName());

        //Check if movie exists and give error
        if (movieByName != null && movieByName.getLanguage().equals(movieRequest.getLanguage())) {
            throw new MovieAlreadyExist();
        }

        Movie movie = MovieConvertor.movieDtoMovie(movieRequest);

        movieRepository.save(movie);
        return "The movie has been added successfully";
    }
}
