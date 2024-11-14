package com.sanuli.movie_ticket_booking_system.movie.convertor;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Movie;
import com.sanuli.movie_ticket_booking_system.movie.request.MovieRequest;

public class MovieConvertor {

    public static Movie movieDtoMovie(MovieRequest movieRequest) {
        Movie movie = Movie.builder().movieName(movieRequest.getMovieName())
                .duration(movieRequest.getDuration())
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .releaseDate(movieRequest.getReleaseDate())
                .rating(movieRequest.getRating())
                .build();
        return movie;
    }
}
