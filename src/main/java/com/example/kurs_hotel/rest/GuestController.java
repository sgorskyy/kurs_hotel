package com.example.kurs_hotel.rest;

import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/guest")
    public ResponseEntity<List<Guest>> findAll() {
        return ResponseEntity.ok(guestService.findAll());
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Optional<Guest>> findById(@PathVariable Long id) {
        if(guestService.findById(id).isPresent()){
            return ResponseEntity.ok(guestService.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/guest/passport/{passNumber}")
    public ResponseEntity<Optional<Guest>> findByPassportNumber(@PathVariable String passNumber) {
        if(guestService.findByPassportNumber(passNumber).isPresent()){
            return ResponseEntity.ok(guestService.findByPassportNumber(passNumber));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/guest/{firstName}/{lastName}")
    public ResponseEntity<Optional<Guest>> findByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        if(guestService.findByFirstNameAndLastName(firstName, lastName).isPresent()){
            return ResponseEntity.ok(guestService.findByFirstNameAndLastName(firstName, lastName));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/guest")
    public ResponseEntity<Void> save(@RequestBody Guest guest) {
            if(guestService.save(guest)){
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/guest/{id}/passport/{passNumber}")
    public ResponseEntity<Void> updatePassport(@PathVariable Long id, @PathVariable String passNumber) {
        if(guestService.updatePassport(id, passNumber)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        };
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
