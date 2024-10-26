package com.hotel.model_service.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerSaveDto {
    String customerName;
    String contactNumber;
    String customerIdNumber;
    String userName;
    String password;

}
