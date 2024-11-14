package com.sanuli.movie_ticket_booking_system.movie.convertor;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Show;
import com.sanuli.movie_ticket_booking_system.movie.enitites.Ticket;
import com.sanuli.movie_ticket_booking_system.movie.response.TicketResponse;

import java.sql.Date;

public class TicketConvertor {
    public static TicketResponse returnTicket(Show show, Ticket ticket) {
        TicketResponse ticketResponseDto = TicketResponse.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheatre().getAddress())
                .theaterName(show.getTheatre().getName())
                .movieName(show.getMovie().getMovieName())
                .date((Date) show.getDate())
                .time(show.getTime())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
