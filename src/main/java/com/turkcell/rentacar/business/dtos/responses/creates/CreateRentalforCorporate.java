package com.turkcell.rentacar.business.dtos.responses.creates;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRentalforCorporate {
	private int carID;
	private int customerId;
    private LocalDateTime dateSent;
    private LocalDateTime dateReturned;
}
