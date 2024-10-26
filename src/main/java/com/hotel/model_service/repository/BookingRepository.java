package com.hotel.model_service.repository;

import com.hotel.model_service.model.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.util.List;


public interface BookingRepository extends CommonRepository<Booking, Integer> {
    @Query(value = "Select b from Booking b where b.bookingId=:id")
    Booking findByBookingID(int id);

    @Query(value = "SELECT * FROM Booking b WHERE DATE(b.inDate) BETWEEN DATE(:fromDate) AND DATE(:toDate) ORDER BY b.inDate", nativeQuery = true)
    List<Booking> findAllBookingDateBetween(LocalDate fromDate, LocalDate toDate);
}
