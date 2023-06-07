package com.example.kurs_hotel.service;

import com.example.kurs_hotel.domain.HostelNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.kurs_hotel.repository.HostelNumberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HostelNumberService {
    private final HostelNumberRepository hostelNumberRepository;


    public List<HostelNumber> findAll() {
                return hostelNumberRepository.findAll();
    }

    public boolean save(HostelNumber hostelNumber) {
        List<HostelNumber> hostelNumbers = hostelNumberRepository.findAll();
        for(HostelNumber hn : hostelNumbers) {
            if(hn.getNumber() == (hostelNumber.getNumber())) {
                return false;
            }
        }
        hostelNumberRepository.save(hostelNumber);
        return true;
    }

    public void updateTVstatus(long number_id, boolean isHasTv) {
        HostelNumber hn = hostelNumberRepository.findById(number_id).get();
        hn.setHasTv(isHasTv);
        hostelNumberRepository.save(hn);
    }


}
