package com.example.airline_api.controllers;

import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {


    @Autowired
    PassengerService passengerService;

    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers()
    {
        List<Passenger> getAllThePassengers = passengerService.findAllPassengers();
        return new ResponseEntity<>(getAllThePassengers, HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable long id)
    {
        Passenger getSpecificPassenger = passengerService.findPassenger(id);
        return new ResponseEntity<>(getSpecificPassenger, HttpStatus.OK);
    }

    // Add a new passenger
    @PostMapping("/passengers")
    public ResponseEntity<Passenger> addNewPassenger(@RequestBody Passenger passenger)
    {
        passengerService.addPassenger(passenger);
        return new ResponseEntity<>(passenger, HttpStatus.CREATED);
    }

}
