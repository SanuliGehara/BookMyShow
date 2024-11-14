package com.sanuli.movie_ticket_booking_system.movie.repositories;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
