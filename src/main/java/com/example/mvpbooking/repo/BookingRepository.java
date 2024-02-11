package com.example.mvpbooking.repo;


import com.example.mvpbooking.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
