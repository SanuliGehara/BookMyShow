package com.sanuli.movie_ticket_booking_system.movie.convertor;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Theatre;
import com.sanuli.movie_ticket_booking_system.movie.request.TheatreRequest;

public class TheatreConvertor {
    public static Theatre theatreDtoTheatre(TheatreRequest theatreRequest) {
        Theatre theatre = Theatre.builder()
                .name(theatreRequest.getName())
                .address(theatreRequest.getName())
                .build();
        return theatre;
    }
}
