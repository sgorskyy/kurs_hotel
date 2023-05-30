package com.example.kurs_hotel.service;

import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(Long id) {
        return guestRepository.findById(id).get();
    }

    public void save(Guest guest) {
        guestRepository.save(guest);
    }

    public void updatePassport(long id, String passNumber) {
        Guest guest = guestRepository.findById(id).get();
        guest.setPassportNumber(passNumber);
        guestRepository.save(guest);
    }
}
