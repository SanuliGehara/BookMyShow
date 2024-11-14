package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class TheatreDoesNotExist extends RuntimeException{
    public static final long serialVersionUID = 2885350098352987873L;

    public TheatreDoesNotExist() {
        super("Theater does not Exists");
    }
}
