package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class UserDoesNotExist extends RuntimeException{
    public static final long serialVersionUID = 293786980937793650L;

    public UserDoesNotExist() {
        super("User is Not Available");
    }
}
