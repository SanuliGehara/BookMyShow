package com.sanuli.movie_ticket_booking_system.movie.convertor;

import com.sanuli.movie_ticket_booking_system.movie.enitites.Show;
import com.sanuli.movie_ticket_booking_system.movie.request.ShowRequest;

public class ShowConvertor {

    public static Show showDtoToShow(ShowRequest showRequest) {
        Show show = Show.builder()
                .time(showRequest.getShowStartTime())
                .date(showRequest.getShowDate())
                .build();

        return show;
    }
}
