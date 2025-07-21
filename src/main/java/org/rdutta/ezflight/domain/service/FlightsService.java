package org.rdutta.ezflight.domain.service;

import org.rdutta.ezflight.domain.dto.FlightsDto;
import org.rdutta.ezflight.domain.model.Flights;

import java.time.LocalTime;
import java.util.List;

public interface FlightsService {

    List<Flights> getAllFlights();   // Fetch all flights as DTOs

    List<Flights> searchFlights(LocalTime startTime, String from, String to);

    Flights getFlightById(int flightNumber);

    String createFlight(FlightsDto flightDto);

    Flights updateFlight(int flightNumber, FlightsDto flightDto);

    void deleteFlight(int flightNumber);
}