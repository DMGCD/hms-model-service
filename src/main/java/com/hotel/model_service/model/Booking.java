package com.hotel.model_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private int bookingId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @Column(name = "inDate", nullable = false)
    private LocalDate inDate;
    @Column(name = "outDate", nullable = false)
    LocalDate outDate;
    @Column(name = "createTime")
    private LocalDateTime createTime;

    @Column(name = "updateTime")
    private LocalDateTime updateTime;
    @OneToOne()
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Room roomId;

    @PrePersist
    protected void onCreateDate() {
        if (createTime == null) {
            createTime = LocalDateTime.now();
        }
    }

    @PreUpdate
    protected void onUpdateDate() {
        if (updateTime == null || updateTime.isBefore(LocalDateTime.now())) {
            updateTime = LocalDateTime.now();

        }
    }
}