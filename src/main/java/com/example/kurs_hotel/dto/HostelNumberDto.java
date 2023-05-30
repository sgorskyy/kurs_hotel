package com.example.kurs_hotel.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HostelNumberDto {
    private long id;
    private int number;
    private boolean isHasTv;
}
