package com.example.kurs_hotel.dto;

import com.example.kurs_hotel.GuestStatuses;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class GuestDto {

        private long  id;
        private String firstName;
        private String lastName;
        private LocalDate dateOfBirth;
        private String passportNumber;
        private GuestStatuses guestStatus;
}
