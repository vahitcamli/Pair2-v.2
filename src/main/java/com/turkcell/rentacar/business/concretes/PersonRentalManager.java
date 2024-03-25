package com.turkcell.rentacar.business.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.abstracts.PersonCustomerService;
import com.turkcell.rentacar.business.abstracts.RentalforPersonService;
import com.turkcell.rentacar.business.abstracts.RentalforPersonService;
import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateRentalforPersonRequest;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateRentalforPersonRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateRentalforPersonResponse;
import com.turkcell.rentacar.business.dtos.responses.updates.UpdatedPersonCustomerResponse;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateRentalforPersonResponse;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.PersonalCustomer;
import com.turkcell.rentacar.entities.concretes.Rental;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
@AllArgsConstructor
@Service
public class PersonRentalManager implements RentalforPersonService {
	private RentalRepository rentalRepository;
	private ModelMapperService modelMapperService;
	private CarService carService;
	private PersonCustomerService personCustomerService;

	@Override
	public CreateRentalforPersonResponse startRentalforPersonCustomer(CreateRentalforPersonRequest createRentalRequest) {
		Rental rental = this.modelMapperService.forRequest().map(createRentalRequest, Rental.class);
		Car car = this.carService.getByIdForRental(createRentalRequest.getCarId());
		PersonalCustomer personalCustomer = this.personCustomerService.getByIdForPersonRental(createRentalRequest.getCustomerId());
		rental.setPersonalCustomer(personalCustomer);
		rental.setStartDate(LocalDateTime.now());
		rental.setCar(car);
		car.setState(2);
		Rental existsRental = this.rentalRepository.save(rental);

		CreateRentalforPersonResponse createRentalResponse = this.modelMapperService.forResponse().map(existsRental,
				CreateRentalforPersonResponse.class);
		return createRentalResponse;

	}

	@Override
	public List<CreateRentalforPersonResponse> getAll() {
		List<CreateRentalforPersonResponse> createRentalResponseList = new ArrayList<>();
		List<Rental> rentalList = this.rentalRepository.findAll();

		for (Rental rental : rentalList) {
			CreateRentalforPersonResponse createRentalResponse = this.modelMapperService.forResponse().map(rental,
					CreateRentalforPersonResponse.class);
			createRentalResponseList.add(createRentalResponse);
		}
		return createRentalResponseList;
	}

	@Override
	public CreateRentalforPersonResponse finishRental(int id) {
//		this.rentalBusinessRules.idIsNotExists(id);
		Rental existsRental = this.rentalRepository.findById(id).get();
		existsRental.setFinishDate(LocalDateTime.now());
		Car car = existsRental.getCar();
		car.setState(1);
		Rental updatedRental = this.rentalRepository.save(existsRental);
		CreateRentalforPersonResponse createRentalforPersonResponse = this.modelMapperService.forResponse().map(updatedRental,
				CreateRentalforPersonResponse.class);
		return createRentalforPersonResponse;
	}



}
