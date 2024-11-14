package com.sanuli.movie_ticket_booking_system.movie.request;

import lombok.Data;

@Data
public class TheatreSeatRequest {
        private String address;
        private Integer noOfSeatInRow;
        private Integer noOfPremiumSeat;
        private Integer noOfClassicSeat;
}
