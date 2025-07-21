package org.rdutta.ezflight.command;

import org.rdutta.ezflight.domain.dto.FlightsDto;

import org.rdutta.ezflight.domain.factory.FlightsFactory;
import org.rdutta.ezflight.domain.model.Flights;
import org.springframework.stereotype.Component;

@Component
public class SaveFlightsToDatabase {
    public static Flights saveFlights(FlightsDto dto){
       return FlightsFactory.createFlights(dto);
    }
}
