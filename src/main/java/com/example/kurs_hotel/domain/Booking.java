package com.example.kurs_hotel.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDate startDate;
    @Column
    private LocalDate  endDate;

    @ManyToOne
    @JoinColumn(name = "hostel_number_id")
    private HostelNumber hostelNumber;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private Guest guest;
}
