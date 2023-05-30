package com.example.kurs_hotel.repository;

import com.example.kurs_hotel.domain.HostelNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostelNumberRepository extends JpaRepository<HostelNumber, Long> {
}
