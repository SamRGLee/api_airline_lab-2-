package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;
    private FlightDTO flightDTO;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(@RequestBody Flight flight)
    {
        List<Flight> getAllTheFlights = flightService.findAllFlights();
        return new ResponseEntity<>(getAllTheFlights, HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable long id)
    {
        Flight getSpecificFlight = flightService.findFlight(id);
        return new ResponseEntity<>(getSpecificFlight, HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping("/flights")
    public ResponseEntity<Flight> addNewFlight(@RequestBody FlightDTO flightDTO)
    {
        Flight addedFlight = flightService.addFlight(flightDTO);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(){
        return null;
    } // I understand the theory behind this - grab a passengers ID, assign it to a flight in the FlightDTO, update that flight - however I would have to look at the solutions to actually implement it

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Long> cancelFlight (@PathVariable long id)
    {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
