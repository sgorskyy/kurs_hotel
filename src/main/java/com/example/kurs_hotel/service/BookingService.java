package com.example.kurs_hotel.service;

import com.example.kurs_hotel.domain.Booking;
import com.example.kurs_hotel.domain.HostelNumber;
import com.example.kurs_hotel.repository.BookingRepository;
import com.example.kurs_hotel.repository.GuestRepository;
import com.example.kurs_hotel.repository.HostelNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final GuestRepository guestRepository;
    private final HostelNumberRepository hostelNumberRepository;

    public List<HostelNumber> findAllFreeNumbersForGivenDates(LocalDate from, LocalDate to) {
        List<Booking> allBookings = bookingRepository.findAll();
        List<HostelNumber>  allNumbers =  hostelNumberRepository.findAll();
        List<HostelNumber>  freeNumbers = new ArrayList<>();

        for (HostelNumber hn : allNumbers){
            boolean isFree = true;

            for (Booking b : allBookings){
                LocalDate startDate = b.getStartDate();
                LocalDate endDate = b.getEndDate();

                if (b.getHostelNumber().getId() == hn.getId()){
                    if(startDate.isEqual(from)||startDate.isEqual(to)||endDate.isEqual(from)||endDate.isEqual(to)){
                        isFree = false;
                    }
                    if(startDate.isAfter(from) && startDate.isBefore(to)){
                        isFree = false;
                    }
                    if (endDate.isAfter(from) && endDate.isBefore(to)){
                        isFree = false;
                    }
                    if (startDate.isBefore(from) && endDate.isAfter(to)){
                        isFree = false;
                    }
                }
            }

            if(isFree){
                freeNumbers.add(hn);
            }
        }

        return freeNumbers;
    }

    public boolean isFree(LocalDate from, LocalDate to, HostelNumber hostelNumber){
        List<HostelNumber> allNumbers = findAllFreeNumbersForGivenDates(from, to);
        for(HostelNumber hn : allNumbers){
            if(hn.getId() == hostelNumber.getId()){
                return true;
            }
        }
        return false;
    }

    public List<Booking> findAll(){
        return bookingRepository.findAll();
    }

    public boolean save(Booking booking, long guestId, long hostelNumberId) {

        booking.setGuest(guestRepository.findById(guestId).get());
        booking.setHostelNumber(hostelNumberRepository.findById(hostelNumberId).get());

        if(isFree(booking.getStartDate(), booking.getEndDate(), booking.getHostelNumber())) {
            bookingRepository.save(booking);
            return true;
        }

        return false;
    }

    public boolean moveGuestToAnotherNumber(Booking booking,long newHostelNumberId){

        if(isFree(booking.getStartDate(), booking.getEndDate(), hostelNumberRepository.findById(newHostelNumberId).get())) {
            booking.setHostelNumber(hostelNumberRepository.findById(newHostelNumberId).get());
            bookingRepository.save(booking);
            return true;
        }
        return false;
    }

}
