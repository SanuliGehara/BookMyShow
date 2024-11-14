package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class TheatreDoesNotExists extends RuntimeException{
    private static final long serialVersionUID = 2885300904271974787L;

    public TheatreDoesNotExists() {
        super("Theatre does not Exists");
    }
}
