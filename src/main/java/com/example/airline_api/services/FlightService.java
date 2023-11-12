package com.example.airline_api.services;import com.example.airline_api.models.Flight;import org.springframework.beans.factory.annotation.Autowired;import com.example.airline_api.repositories.FlightRepository;import org.springframework.stereotype.Service;import java.util.List;@Servicepublic class FlightService{    @Autowired    FlightRepository flightRepository;    @Autowired    PassengerService passengerService;    public Flight addFlight(Flight flight)    {        flightRepository.save(flight);        return flight;    }    public Flight findFlight(long id)    {        return flightRepository.findById(id).get();    }    public List<Flight> findAllFlights()    {        return flightRepository.findAll();    }    public void deleteFlight(long id)    {        flightRepository.deleteById(id);    }}