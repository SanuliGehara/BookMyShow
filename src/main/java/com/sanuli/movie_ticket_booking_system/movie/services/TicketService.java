package com.sanuli.movie_ticket_booking_system.movie.services;

import com.sanuli.movie_ticket_booking_system.movie.convertor.TicketConvertor;
import com.sanuli.movie_ticket_booking_system.movie.enitites.Show;
import com.sanuli.movie_ticket_booking_system.movie.enitites.ShowSeat;
import com.sanuli.movie_ticket_booking_system.movie.enitites.Ticket;
import com.sanuli.movie_ticket_booking_system.movie.enitites.User;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.SeatNotAvailable;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.ShowDoesNotExists;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.UserDoesNotExist;
import com.sanuli.movie_ticket_booking_system.movie.repositories.ShowRepository;
import com.sanuli.movie_ticket_booking_system.movie.repositories.TicketRepository;
import com.sanuli.movie_ticket_booking_system.movie.repositories.UserRepository;
import com.sanuli.movie_ticket_booking_system.movie.request.TicketRequest;
import com.sanuli.movie_ticket_booking_system.movie.response.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private UserRepository userRepository;

    public TicketResponse ticketBooking(TicketRequest ticketRequest) {
        Optional<Show> showOpt = showRepository.findById(ticketRequest.getShowId());

        if(showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }

        Optional<User> userOpt = userRepository.findById(ticketRequest.getUserId());

        if (userOpt.isEmpty()) {
            throw new UserDoesNotExist();
        }

        User user = userOpt.get();
        Show show = showOpt.get();

        Boolean isSeatAvailable = isSeatAvailable(show.getShowSeatList(),ticketRequest.getRequestSeats());

        if(!isSeatAvailable) {
            throw new SeatNotAvailable();
        }

        //count price
        Integer getPriceAndAssignSeats = getPriceAndAssignSeats(show.getShowSeatList(),ticketRequest.getRequestSeats());

        String seats = listToString(ticketRequest.getRequestSeats());

        // complete ticket booking process
        Ticket ticket = new Ticket();
        ticket.setTotalTicketsPrice(getPriceAndAssignSeats);
        ticket.setBookedSeats(seats);
        ticket.setUser(user);
        ticket.setShow(show);

        //save ticket info to db
        ticket = ticketRepository.save(ticket);

        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        userRepository.save(user);
        showRepository.save(show);

        return TicketConvertor.returnTicket(show,ticket);
    }

    private Boolean isSeatAvailable(List<ShowSeat> showSeatList, List<String> requestSeats) {
        for (ShowSeat showSeat : showSeatList) {
            String seatNo = showSeat.getSeatNo();

            if (requestSeats.contains(seatNo) && !showSeat.getIsAvailable()) {
                return false;
            }
        }

        return true;
    }

    private Integer getPriceAndAssignSeats(List<ShowSeat> showSeatList, List<String> requestSeats) {
        Integer totalAmount = 0;

        for (ShowSeat showSeat : showSeatList) {
            if (requestSeats.contains(showSeat.getSeatNo())) {
                totalAmount += showSeat.getPrice();
                showSeat.setIsAvailable(Boolean.FALSE);
            }
        }

        return totalAmount;
    }

    private String listToString(List<String> requestSeats) {
        StringBuilder sb = new StringBuilder();

        for (String s : requestSeats) {
            sb.append(s).append(",");
        }

        return sb.toString();
    }

}
