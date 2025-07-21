package org.rdutta.ezflight.infrastructure.implementation;

import org.rdutta.ezflight.command.SaveFlightsToDatabase;
import org.rdutta.ezflight.domain.dto.FlightsDto;
import org.rdutta.ezflight.domain.model.Flights;
import org.rdutta.ezflight.domain.service.FlightsService;
import org.rdutta.ezflight.infrastructure.exceptions.FlightsNotFound;
import org.rdutta.ezflight.infrastructure.exceptions.error.FlightError;
import org.rdutta.ezflight.infrastructure.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class FlightsServiceImpl implements FlightsService {
    @Autowired
    private FlightsRepository flightsRepository;
    @Override
    public List<Flights> getAllFlights() {
        return flightsRepository.findAll();
    }

    @Override
    public Flights getFlightById(int flightNumber) {
        return flightsRepository.findById(flightNumber).orElseThrow(()->new FlightsNotFound(FlightError.noFlights));
    }

    @Override
    public String createFlight(FlightsDto flightDto) {
        flightsRepository.save(SaveFlightsToDatabase.saveFlights(flightDto));
        return "Successfully saved to database.";
    }

    @Override
    public Flights updateFlight(int flightNumber, FlightsDto flightDto) {
        return null;
    }

    @Override
    public void deleteFlight(int flightNumber) {

    }

    @Override
    public List<Flights> searchFlights(LocalTime startTime, String from, String to) {
        return flightsRepository.findAllFlightsFromSourceToDestination(from, to, startTime);
    }
}
