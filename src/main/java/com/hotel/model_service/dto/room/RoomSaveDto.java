package com.hotel.model_service.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomSaveDto {
    private String roomType;
    private String roomFacility;
    private Long roomPrice;
}
