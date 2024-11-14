package com.sanuli.movie_ticket_booking_system.movie.repositories;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    Theatre findByAddress(String address);
}
