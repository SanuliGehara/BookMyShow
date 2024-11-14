package com.sanuli.movie_ticket_booking_system.movie.services;

import com.sanuli.movie_ticket_booking_system.movie.convertor.TheatreConvertor;
import com.sanuli.movie_ticket_booking_system.movie.enitites.Theatre;
import com.sanuli.movie_ticket_booking_system.movie.enitites.TheatreSeat;
import com.sanuli.movie_ticket_booking_system.movie.enums.SeatType;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.TheatreDoesNotExist;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.TheatreExist;
import com.sanuli.movie_ticket_booking_system.movie.repositories.TheatreRepository;
import com.sanuli.movie_ticket_booking_system.movie.request.TheatreRequest;
import com.sanuli.movie_ticket_booking_system.movie.request.TheatreSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;

    public String addTheatre(TheatreRequest theatreRequest) throws TheatreExist {
        if (theatreRepository.findByAddress(theatreRequest.getAddress()) != null) {
            throw new TheatreExist();
        }

        Theatre theatre = TheatreConvertor.theatreDtoTheatre(theatreRequest);

        theatreRepository.save(theatre);
        return "Theatre has been saved successfully";
    }

    public String addTheatreSeat(TheatreSeatRequest entryDto) throws TheatreDoesNotExist {
        if(theatreRepository.findByAddress(entryDto.getAddress()) == null) {
            throw new TheatreDoesNotExist();
        }

        Integer noOfSeatInRow = entryDto.getNoOfSeatInRow();
        Integer noOfPremiumSeats = entryDto.getNoOfPremiumSeat();
        Integer noOfClassicSeats = entryDto.getNoOfClassicSeat();
        String address = entryDto.getAddress();

        Theatre theatre = theatreRepository.findByAddress(address);

        List<TheatreSeat> seatList = theatre.getTheatreSeatList();

        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for (int i = 1; i <= noOfClassicSeats; i++) {
            String seatNo = Integer.toString(counter) + ch;

            ch++;
            fill++;
            if(fill == noOfSeatInRow) {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(seatNo);
            theatreSeat.setSeatType(SeatType.CLASSIC);
            theatreSeat.setTheatre(theatre);
            seatList.add(theatreSeat);
        }

        for (int i = 1; i <= noOfPremiumSeats; i++) {
            String seatNo = Integer.toString(counter) + ch;

            ch++;
            fill++;
            if(fill == noOfSeatInRow) {
                fill = 0;
                counter++;
                ch = 'A';
            }

            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(seatNo);
            theatreSeat.setSeatType(SeatType.PREMIUM);
            theatreSeat.setTheatre(theatre);
            seatList.add(theatreSeat);
        }

        theatreRepository.save(theatre);
        return "Theatre Seats have been added successfully";
    }
}
