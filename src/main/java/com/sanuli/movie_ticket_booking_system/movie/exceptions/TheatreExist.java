package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class TheatreExist extends RuntimeException{
    public static final long serialVersionUID = 6386810783666583528L;

    public TheatreExist() {
        super("Theater is already Present on this Address");
    }
}
