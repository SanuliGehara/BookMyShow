package com.sanuli.movie_ticket_booking_system.movie.request;
import com.sanuli.movie_ticket_booking_system.movie.enums.Genre;
import com.sanuli.movie_ticket_booking_system.movie.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
