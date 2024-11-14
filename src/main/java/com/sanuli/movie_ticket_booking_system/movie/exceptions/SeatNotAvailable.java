package com.sanuli.movie_ticket_booking_system.movie.exceptions;

public class SeatNotAvailable extends RuntimeException{
    public static final long serialVersionUID = 1497113945165128412L;

    public SeatNotAvailable() {
        super("Requested Seats Are Not Available");
    }
}
