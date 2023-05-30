package com.example.kurs_hotel.dto;

import com.example.kurs_hotel.domain.Guest;
import com.example.kurs_hotel.domain.HostelNumber;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookingDto {
    private long id;
    private LocalDate startDate;
    private LocalDate  endDate;
    private HostelNumber hostelNumber;
    private Guest guest;
}
