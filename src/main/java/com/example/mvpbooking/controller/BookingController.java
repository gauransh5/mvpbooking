package com.example.mvpbooking.controller;

import com.example.mvpbooking.models.Booking;
import com.example.mvpbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        try {
            Long bookingId = bookingService.createBooking(booking);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Booking created successfully. Booking ID: " + bookingId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error creating booking: " + e.getMessage());
        }
    }
    @GetMapping("/bookings")
    public ResponseEntity<List  <Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.ok(bookings);
    }
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId) {
        try {
            Booking booking = bookingService.getBooking(bookingId);
            return ResponseEntity.ok(booking);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        try {
            bookingService.deleteBooking(bookingId);
            return ResponseEntity.ok("Booking deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/bookings/{bookingId}")
    public ResponseEntity<String> updateBooking(@PathVariable Long bookingId, @RequestBody Booking updatedBooking) {
        try {
            bookingService.updateBooking(bookingId, updatedBooking);
            return ResponseEntity.ok("Booking updated successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
