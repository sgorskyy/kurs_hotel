package com.example.kurs_hotel.domain;

import com.example.kurs_hotel.GuestStatuses;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private String passportNumber;
    @Column
    private GuestStatuses guestStatus = GuestStatuses.STANDARD;

}
