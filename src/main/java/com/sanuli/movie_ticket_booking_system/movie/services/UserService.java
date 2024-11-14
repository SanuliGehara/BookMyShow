package com.sanuli.movie_ticket_booking_system.movie.services;

import com.sanuli.movie_ticket_booking_system.movie.convertor.UserConvertor;
import com.sanuli.movie_ticket_booking_system.movie.enitites.User;
import com.sanuli.movie_ticket_booking_system.movie.exceptions.UserExist;
import com.sanuli.movie_ticket_booking_system.movie.repositories.UserRepository;
import com.sanuli.movie_ticket_booking_system.movie.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(UserRequest userRequest) {
        if (userRepository.findByEmailId(userRequest.getEmailId()) != null) {
            throw new UserExist();
        }

        User user = UserConvertor.userDtoToUser(userRequest);

        userRepository.save(user);
        return "User Saved Successfully";
    }
}
