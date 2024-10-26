package com.hotel.model_service.model;

import com.hotel.model_service.model.enums.RoomFacilities;
import com.hotel.model_service.model.enums.RoomType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private int roomID;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "roomType", nullable = false)
    private RoomType roomType;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "roomFacility")
    private RoomFacilities roomFacility;
    @Column(name = "available", columnDefinition = "TINYINT() default 0")
    private boolean available;
    @Column(name = "roomPrice", nullable = false)
    private Long roomPrice;
    @OneToOne(mappedBy = "roomId", cascade = CascadeType.ALL)
    private Booking booking;

}
