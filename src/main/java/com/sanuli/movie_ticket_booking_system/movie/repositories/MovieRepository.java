package com.sanuli.movie_ticket_booking_system.movie.repositories;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findByMovieName(String name);
}
