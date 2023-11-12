package com.example.airline_api.services;import com.example.airline_api.models.Flight;import com.example.airline_api.models.Passenger;import org.springframework.beans.factory.annotation.Autowired;import com.example.airline_api.repositories.PassengerRepository;import java.util.List;public class PassengerService{    @Autowired    PassengerRepository passengerRepository;    public void addPassenger(Passenger passenger)    {        passengerRepository.save(passenger);    }    public Passenger findPassenger(Long id)    {        return passengerRepository.findById(id).get();    }    public List<Passenger> findAllPassengers()    {        return passengerRepository.findAll();    }    public void deletePassenger(long id)    {        Passenger passenger = passengerRepository.findById(id).get();        for (Flight flight : passenger.getFlights())        {            flight.removePassenger(passenger);        }        passengerRepository.deleteById(id);    }}