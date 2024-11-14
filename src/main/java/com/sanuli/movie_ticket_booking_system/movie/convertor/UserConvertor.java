package com.sanuli.movie_ticket_booking_system.movie.convertor;

import com.sanuli.movie_ticket_booking_system.movie.enitites.User;
import com.sanuli.movie_ticket_booking_system.movie.request.UserRequest;
import com.sanuli.movie_ticket_booking_system.movie.response.UserResponse;

public class UserConvertor {
    public static User userDtoToUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .gender(userRequest.getGender())
                .mobileNo(userRequest.getMobileNo())
                .email(userRequest.getEmailId())
                .build();

        return user;
    }

    public static UserResponse userToUserDto(User user) {
        UserResponse userDto = UserResponse.builder()
                .name(user.getName())
                .age(user.getAge())
                .address(user.getAddress())
                .gender(user.getGender())
                .build();

        return userDto;
    }
}
