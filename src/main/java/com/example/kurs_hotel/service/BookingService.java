package com.example.kurs_hotel.service;

import com.example.kurs_hotel.GuestStatuses;
import com.example.kurs_hotel.domain.Booking;
import com.example.kurs_hotel.domain.HostelNumber;
import com.example.kurs_hotel.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final HostelNumberService hostelNumberService;

    public List<HostelNumber> findAllFreeNumbers(LocalDate from, LocalDate to) {
        List<Booking> allBookings = bookingRepository.findAll();
        List<HostelNumber>  allNumbers =  hostelNumberService.findAll();
        List<HostelNumber>  freeNumbers = new ArrayList<>();
        allNumbers.forEach(hn -> {
            allBookings.forEach(b -> {
                if (b.getHostelNumber().getId() == hn.getId() && b.getStartDate().isAfter(from) && b.getEndDate().isBefore(to)) {
                    freeNumbers.add(hn);
                }
            });
        });

        return freeNumbers;
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }
}
