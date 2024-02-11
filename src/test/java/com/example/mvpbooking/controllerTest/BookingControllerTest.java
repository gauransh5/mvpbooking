package com.example.mvpbooking.controllerTest;

import com.example.mvpbooking.controller.BookingController;
import com.example.mvpbooking.models.Booking;
import com.example.mvpbooking.service.BookingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

    @InjectMocks
    private BookingController bookingController;

    @Mock
    private BookingService bookingService;

    @Test
    public void testCreateBooking_Success() {

        Booking validBooking = new Booking();

        Long expectedBookingId = 123L;


        when(bookingService.createBooking(any(Booking.class))).thenReturn(expectedBookingId);


        ResponseEntity<String> response = bookingController.createBooking(validBooking);


        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertTrue(response.getBody().contains("Booking created successfully"));
        assertTrue(response.getBody().contains("Booking ID: " + expectedBookingId));

    }
    @Test
    public void testGetBookingById_Success() {
        // Arrange
        Long existingBookingId = 123L;
        Booking expectedBooking = new Booking();
        expectedBooking.setId(existingBookingId);
        expectedBooking.setUserId(103L);
        expectedBooking.setHotelId(203L);
        expectedBooking.setCheckInDate(LocalDate.of(2024, 7, 5));
        expectedBooking.setCheckOutDate(LocalDate.of(2024, 7, 10));
        when(bookingService.getBooking(existingBookingId)).thenReturn(expectedBooking);
        ResponseEntity<Booking> response = bookingController.getBooking(existingBookingId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(expectedBooking.getId(), response.getBody().getId());

    }

}

