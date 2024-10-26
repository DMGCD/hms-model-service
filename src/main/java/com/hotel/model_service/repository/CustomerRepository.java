package com.hotel.model_service.repository;

import com.hotel.model_service.model.Booking;
import com.hotel.model_service.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.time.LocalDate;
import java.util.List;


public interface CustomerRepository extends CommonRepository<Customer, Integer>{
   @Query(value = "UPDATE Customer c SET c.userName = :userName, c.password = :password WHERE c.id = :id",nativeQuery = true)
    Customer updateUserNamePassword(String userName ,String Passowrd,int id);
    @Query(value = "SELECT * FROM Booking b WHERE DATE(b.inDate) BETWEEN DATE(:fromDate) AND DATE(:toDate) ORDER BY b.inDate", nativeQuery = true)
    List<Booking> findAllBookingDateBetween(LocalDate fromDate, LocalDate toDate);
}
