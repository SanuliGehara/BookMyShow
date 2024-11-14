package com.sanuli.movie_ticket_booking_system.movie.repositories;

import com.sanuli.movie_ticket_booking_system.movie.enitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailId(String emailId);;
}
