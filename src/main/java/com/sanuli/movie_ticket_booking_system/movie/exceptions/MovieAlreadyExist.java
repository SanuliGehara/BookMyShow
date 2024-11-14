package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class MovieAlreadyExist extends RuntimeException{
    private static final long serialVersionUID = 872140731937376481L;

    public MovieAlreadyExist() {
        super("Movie already exists with same name and language");
    }
}
