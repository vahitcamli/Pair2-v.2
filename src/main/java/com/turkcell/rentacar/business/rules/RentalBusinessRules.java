//package com.turkcell.rentacar.business.rules;
//
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.turkcell.rentacar.business.messages.FuelMessages;
//import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
//import com.turkcell.rentacar.dataAccess.abstracts.CorporateCustomerRepository;
//import com.turkcell.rentacar.dataAccess.abstracts.PersonCustomerRepository;
//import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
//import com.turkcell.rentacar.entities.concretes.CorporateCustomer;
//import com.turkcell.rentacar.entities.concretes.PersonalCustomer;
//import com.turkcell.rentacar.entities.concretes.Rental;
//
//import lombok.AllArgsConstructor;
//
//@Service
//@AllArgsConstructor
//public class RentalBusinessRules {
//	private RentalRepository rentalRepository;
//	private PersonCustomerRepository personCustomerRepository;
//	private CorporateCustomerRepository corporateCustomerRepository;
//	private Rental rental;
//	public void idIsNotExists(int id) {
//		Optional<Rental> rental = this.rentalRepository.findById(id);
//		if (rental.isEmpty()) {
//			throw new BusinessException(FuelMessages.idIsNotExists);
//		}
//	}
//}