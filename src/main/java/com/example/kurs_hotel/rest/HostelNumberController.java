package com.example.kurs_hotel.rest;

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
    public ResponseEntity<List<HostelNumber>> findAll() {
        return ResponseEntity.ok(hostelNumberService.findAll());
    }

    @PostMapping("/number")
    public ResponseEntity<Void> save(@RequestBody HostelNumber hostelNumber) {
        if(hostelNumberService.save(hostelNumber)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/number/{id}/tv/{tv_status}")
    public ResponseEntity<Void> updateTVstatus(@PathVariable Long number_id, @PathVariable boolean tvStatus) {
        hostelNumberService.updateTVstatus(number_id, tvStatus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
