package com.sanuli.movie_ticket_booking_system.movie.request;

import lombok.Data;

import java.util.List;

@Data
public class TicketRequest {
    private Integer showId;
    private Integer userId;
    private List<String > requestSeats;
}
