package com.example.mvpbooking.service;


import com.example.mvpbooking.models.Booking;
import com.example.mvpbooking.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Long createBooking(Booking booking) {
        return bookingRepository.save(booking).getId();
    }

    public Booking getBooking(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void deleteBooking(Long bookingId) {

        bookingRepository.deleteById(bookingId);
    }

    public void updateBooking(Long bookingId, Booking updatedBooking) {

        Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        existingBooking.setUserId(updatedBooking.getUserId());
        existingBooking.setHotelId(updatedBooking.getHotelId());
        existingBooking.setCheckOutDate(updatedBooking.getCheckOutDate());
        existingBooking.setCheckInDate(updatedBooking.getCheckInDate());
        bookingRepository.save(existingBooking);
    }
}

