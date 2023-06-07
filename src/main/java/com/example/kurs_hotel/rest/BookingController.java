package com.example.kurs_hotel.rest;

import com.example.kurs_hotel.domain.Booking;
import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.domain.HostelNumber;
import com.example.kurs_hotel.service.BookingService;
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
    public ResponseEntity<List<Booking>> findAll() {
        return ResponseEntity.ok(bookingService.findAll());
    }

    @GetMapping("/booking/{from}/{to}")
    public ResponseEntity<List<HostelNumber>> findAllFreeNumbers(@PathVariable LocalDate from, @PathVariable LocalDate to) {
        return ResponseEntity.ok(bookingService.findAllFreeNumbersForGivenDates(from, to));
    }

    @PostMapping("/booking/book/{guestId}/{hostelNumberId}")
    public ResponseEntity<Void> save(@RequestBody Booking booking, @PathVariable Long guestId, @PathVariable Long hostelNumberId) {

        if(bookingService.save(booking, guestId, hostelNumberId)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/booking/relocate/{newnumber}")
    public ResponseEntity<Void> moveToNumber(@RequestBody Booking booking,@PathVariable Long newnumber) {
        if(bookingService.moveGuestToAnotherNumber(booking, newnumber)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
