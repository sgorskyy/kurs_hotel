package com.example.kurs_hotel.rest;

import com.example.kurs_hotel.domain.Booking;
import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.domain.HostelNumber;
import com.example.kurs_hotel.service.BookingService;
import com.example.kurs_hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/booking")
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/booking/{from}/{to}")
    public List<HostelNumber> findAllFreeNumbers(@PathVariable LocalDate from, @PathVariable LocalDate to) {
        return bookingService.findAllFreeNumbers(from, to);
    }

    @PostMapping("/booking/book")
    public ResponseEntity<Guest> save(@RequestBody Booking booking) {

        bookingService.save(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
