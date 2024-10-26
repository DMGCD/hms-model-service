package com.hotel.model_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    int customerId;
    @Column(name = "name", nullable = false)
    String customerName;
    @Column(name = "contactNumber", nullable = false)
    String contactNumber;
    @Column(name = "customerIdNumber", nullable = false)
    String customerIdNumber;
    @Column(name = "userName", nullable = false)
    String userName;
    @Column(name = "password", nullable = false)
    String password;
    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private Set<Booking> bookingDetails;

    @Column(name = "createTime")
    private LocalDateTime createTime;

    @Column(name = "updateTime")
    private LocalDateTime updateTime;

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

    public Customer(String customerName, String contactNumber, String customerIdNumber, String userName, String password) {
        this.customerName = customerName;
        this.contactNumber = contactNumber;
        this.customerIdNumber = customerIdNumber;
        this.userName = userName;
        this.password = password;
    }
}
