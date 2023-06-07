package com.example.kurs_hotel.service;

import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Optional<Guest> findById(Long id) {
        return guestRepository.findById(id);
    }

    public Optional<Guest> findByPassportNumber(String passportNumber) {
        return guestRepository.findByPassportNumber(passportNumber);
    }

    public Optional<Guest> findByFirstNameAndLastName(String firstName, String lastName) {
        return guestRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public boolean save(Guest guest) {
        if(!guestRepository.findByPassportNumber(guest.getPassportNumber()).isPresent()) {
            if(!guestRepository.findByFirstNameAndLastName(guest.getFirstName(), guest.getLastName()).isPresent()) {
                guestRepository.save(guest);
                return true;
            }
        }
        return false;
    }

    public boolean updatePassport(long id, String passNumber) {
        Guest guest = guestRepository.findById(id).get();
        if(!guestRepository.findByPassportNumber(passNumber).isPresent()){
            guest.setPassportNumber(passNumber);
            guestRepository.save(guest);
            return true;
        }
        return false;
    }
}
