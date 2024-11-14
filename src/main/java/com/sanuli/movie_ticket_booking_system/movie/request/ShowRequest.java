package com.sanuli.movie_ticket_booking_system.movie.request;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ShowRequest {

    private Time showStartTime;
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
}
