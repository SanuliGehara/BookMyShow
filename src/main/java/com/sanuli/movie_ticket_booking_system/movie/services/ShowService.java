package com.sanuli.movie_ticket_booking_system.movie.services;

import com.sanuli.movie_ticket_booking_system.movie.convertor.ShowConvertor;
import com.sanuli.movie_ticket_booking_system.movie.enitites.*;
import com.sanuli.movie_ticket_booking_system.movie.enums.SeatType;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.MovieDoesNotExists;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.ShowDoesNotExists;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.TheatreDoesNotExists;
import com.sanuli.movie_ticket_booking_system.movie.repositories.MovieRepository;
import com.sanuli.movie_ticket_booking_system.movie.repositories.ShowRepository;
import com.sanuli.movie_ticket_booking_system.movie.repositories.TheatreRepository;
import com.sanuli.movie_ticket_booking_system.movie.request.ShowRequest;
import com.sanuli.movie_ticket_booking_system.movie.request.ShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addShow(ShowRequest showRequest) {
        Show show = ShowConvertor.showDtoToShow(showRequest);

        Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

        if(movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }

        Optional<Theatre> theatreOpt = theatreRepository.findById(showRequest.getTheaterId());

        if(theatreOpt.isEmpty()) {
            throw new TheatreDoesNotExists();
        }

        Theatre theatre = theatreOpt.get();
        Movie movie = movieOpt.get();

        show.setMovie(movie);
        show.setTheatre(theatre);
        show = showRepository.save(show);

        movie.getShows();
        theatre.getShowList().add(show);

        movieRepository.save(movie);
        theatreRepository.save(theatre);

        return "Show has been added successfully";
    }

    public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExists {
        Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

        if(showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }

        Show show = showOpt.get();
        Theatre theatre = show.getTheatre();

        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();

        for (TheatreSeat theatreSeat : theatreSeatList) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theatreSeat.getSeatNo());
            showSeat.setSeatType(theatreSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice(showSeatRequest.getPriceOfClassicSeat());
            } else {
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContains(Boolean.FALSE);

            showSeatList.add(showSeat);
        }

        showRepository.save(show);

        return "Show seats have been associated successfully";
    }
}
