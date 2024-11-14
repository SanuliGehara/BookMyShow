package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class ShowDoesNotExists extends RuntimeException{
    public static final long serialVersionUID = -4436119261176031165L;

    public ShowDoesNotExists() {
        super("Show does not exists");
    }
}
