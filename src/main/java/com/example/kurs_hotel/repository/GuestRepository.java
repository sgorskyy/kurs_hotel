package com.example.kurs_hotel.repository;

import com.example.kurs_hotel.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findByPassportNumber(String passportNumber);
    Optional<Guest> findByFirstNameAndLastName(String firstName, String lastName);

}
