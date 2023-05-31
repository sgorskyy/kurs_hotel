package com.example.kurs_hotel.rest;

import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/guest")
    public List<Guest> findAll() {
        return guestService.findAll();
    }

    @GetMapping("/guest/{id}")
    public Guest findById(@PathVariable Long id) {
        return guestService.findById(id);
    }

    @PostMapping("/guest")
    public ResponseEntity<Guest> save(@RequestBody Guest guest) {
            guestService.save(guest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

    @PostMapping("/guest/{id}/passport/{passNumber}")
    public ResponseEntity<Void> updatePassport(@PathVariable Long id, @PathVariable String passNumber) {
        guestService.updatePassport(id, passNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
