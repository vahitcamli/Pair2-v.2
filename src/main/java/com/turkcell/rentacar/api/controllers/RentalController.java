package com.turkcell.rentacar.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.abstracts.RentalforPersonService;
import com.turkcell.rentacar.business.abstracts.RentalforPersonService;
import com.turkcell.rentacar.business.dtos.requests.creates.CreateRentalforPersonRequest;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateRentalforPersonResponse;
import com.turkcell.rentacar.business.dtos.responses.creates.CreateRentalforPersonResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/rentalsforperson")
public class RentalController {
private RentalforPersonService rentalService;

@PostMapping("/startRental")
@ResponseStatus(HttpStatus.CREATED)
public CreateRentalforPersonResponse startRental(@RequestBody CreateRentalforPersonRequest createRentalRequest){
    return this.rentalService.startRentalforPersonCustomer( createRentalRequest);
}
@GetMapping("/getall")
public List<CreateRentalforPersonResponse> getAll(){
    return this.rentalService.getAll();
}
@PostMapping("/finishMaintenance/{id}")
public CreateRentalforPersonResponse finishMaintence(@PathVariable int id) {
    return this.rentalService.finishRental( id);
}
}
