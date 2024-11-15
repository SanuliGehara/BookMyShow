package com.sanuli.movie_ticket_booking_system.movie.request;

import com.sanuli.movie_ticket_booking_system.movie.enums.Gender;
import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
    private String roles;
}
