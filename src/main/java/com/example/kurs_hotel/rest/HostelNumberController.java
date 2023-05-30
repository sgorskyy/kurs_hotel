package com.example.kurs_hotel.rest;

import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.domain.HostelNumber;
import com.example.kurs_hotel.service.HostelNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HostelNumberController {

    private final HostelNumberService hostelNumberService;

    @GetMapping("/number")
    public List<HostelNumber> findAll() {
        return hostelNumberService.findAll();
    }

    @GetMapping("/number/{id}")
    public HostelNumber findById(@PathVariable Long id) {
        return hostelNumberService.findById(id);
    }

    @PostMapping("/number")
    public ResponseEntity<HostelNumber> save(@RequestBody HostelNumber hostelNumber) {
        hostelNumberService.save(hostelNumber);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/number/{id}/tv/{tv_status}")
    public ResponseEntity<Void> updateTVstatus(@PathVariable Long number_id, @PathVariable boolean tvStatus) {
        hostelNumberService.updateTVstatus(number_id, tvStatus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
