package com.sanuli.movie_ticket_booking_system.movie.controllers;

import com.sanuli.movie_ticket_booking_system.movie.request.TheatreRequest;
import com.sanuli.movie_ticket_booking_system.movie.request.TheatreSeatRequest;
import com.sanuli.movie_ticket_booking_system.movie.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatre")
public class TheatreController {

    @Autowired
    public TheatreService theatreService;

    @PostMapping("/addNew")
    public ResponseEntity<String> addTheatre(@RequestBody TheatreRequest request) {
        try {
            String result = theatreService.addTheatre(request);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        }   catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addTheatreSeat")
    public ResponseEntity<String> addTheatreSeat(@RequestBody TheatreSeatRequest entryDto) {
        try {
            String result = theatreService.addTheatreSeat(entryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
